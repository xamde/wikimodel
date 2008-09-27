/*******************************************************************************
 * Copyright (c) 2005,2006 Cognium Systems SA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cognium Systems SA - initial API and implementation
 *******************************************************************************/
package org.wikimodel.wem.xhtml.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wikimodel.wem.WikiPageUtil;
import org.wikimodel.wem.WikiParameter;
import org.wikimodel.wem.WikiParameters;
import org.wikimodel.wem.impl.WikiScannerContext;
import org.wikimodel.wem.xhtml.XhtmlCharacter;
import org.wikimodel.wem.xhtml.XhtmlCharacterType;
import org.wikimodel.wem.xhtml.XhtmlEscapeHandler;
import org.wikimodel.wem.xhtml.handler.BoldTagHandler;
import org.wikimodel.wem.xhtml.handler.DefinitionDescriptionTagHandler;
import org.wikimodel.wem.xhtml.handler.DefinitionListTagHandler;
import org.wikimodel.wem.xhtml.handler.DefinitionTermTagHandler;
import org.wikimodel.wem.xhtml.handler.DivisionTagHandler;
import org.wikimodel.wem.xhtml.handler.HeaderTagHandler;
import org.wikimodel.wem.xhtml.handler.HorizontalLineTagHandler;
import org.wikimodel.wem.xhtml.handler.ItalicTagHandler;
import org.wikimodel.wem.xhtml.handler.LineBreakTagHandler;
import org.wikimodel.wem.xhtml.handler.ListItemTagHandler;
import org.wikimodel.wem.xhtml.handler.ListTagHandler;
import org.wikimodel.wem.xhtml.handler.ParagraphTagHandler;
import org.wikimodel.wem.xhtml.handler.PreserveTagHandler;
import org.wikimodel.wem.xhtml.handler.QuoteTagHandler;
import org.wikimodel.wem.xhtml.handler.ReferenceTagHandler;
import org.wikimodel.wem.xhtml.handler.StrikedOutTagHandler;
import org.wikimodel.wem.xhtml.handler.SubScriptTagHandler;
import org.wikimodel.wem.xhtml.handler.SuperScriptTagHandler;
import org.wikimodel.wem.xhtml.handler.TableDataTagHandler;
import org.wikimodel.wem.xhtml.handler.TableRowTagHandler;
import org.wikimodel.wem.xhtml.handler.TableTagHandler;
import org.wikimodel.wem.xhtml.handler.TagHandler;
import org.wikimodel.wem.xhtml.handler.TeletypeTagHandler;
import org.wikimodel.wem.xhtml.handler.UnderlineTagHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author kotelnikov
 * @author vmassol
 */
public class XhtmlHandler extends DefaultHandler {

    public static class TagStack {

        public class TagContext {

            private final Attributes fAttributes;

            private StringBuffer fContent;

            public TagHandler fHandler;

            String fLocalName;

            private final TagContext fParent;

            String fQName;

            String fUri;

            TagStack fTagStack;
            
            public TagContext(
                TagContext parent,
                String uri,
                String localName,
                String qName,
                Attributes attributes,
                TagStack tagStack) {
                fUri = uri;
                fLocalName = localName;
                fQName = qName;
                fParent = parent;
                fAttributes = attributes;
                fTagStack = tagStack; 
            }

            public boolean appendContent(char[] array, int start, int length) {
                if (fHandler == null || !fHandler.isAccumulateContent())
                    return false;
                if (fContent == null) {
                    fContent = new StringBuffer();
                }
                fContent.append(array, start, length);
                return true;
            }

            public void beginElement(TagHandler handler) {
                if (fParent == null) {
                    fScannerContext.beginDocument();
                }
                fHandler = handler;
                if (fHandler != null) {
                    fHandler.beginElement(this);
                }
            }

            public void endElement() {
                if (fHandler != null) {
                    fHandler.endElement(this);
                }
                if (fParent == null) {
                    fScannerContext.endDocument();
                }
            }

            public String getContent() {
                return fContent != null ? WikiPageUtil.escapeXmlString(fContent
                    .toString()) : "";
            }

            public String getLocalName() {
                return fLocalName;
            }

            private String getLocalName(
                String uri,
                String localName,
                String name,
                boolean upperCase) {
                String result = (localName != null && !"".equals(localName))
                    ? localName
                    : name;
                return upperCase ? result.toUpperCase() : result;
            }

            public String getName() {
                return getLocalName(fUri, fLocalName, fQName, false);
            }

            public WikiParameters getParams() {
                List<WikiParameter> list = new ArrayList<WikiParameter>();
                int len = fAttributes != null ? fAttributes.getLength() : 0;
                for (int i = 0; i < len; i++) {
                    String key = getLocalName(
                        fAttributes.getURI(i),
                        fAttributes.getQName(i),
                        fAttributes.getLocalName(i),
                        false);
                    String value = fAttributes.getValue(i);
                    WikiParameter param = new WikiParameter(key, value);
                    list.add(param);
                }
                WikiParameters params = new WikiParameters(list);
                return params;
            }

            public TagContext getParent() {
                return fParent;
            }

            public String getQName() {
                return fQName;
            }

            public WikiScannerContext getScannerContext() {
                return fScannerContext;
            }

            public String getUri() {
                return fUri;
            }

            public TagStack getTagStack() {
                return fTagStack;
            }
            
            public boolean isContentContainer() {
                return fHandler == null || fHandler.isContentContainer();
            }

            public boolean isTag(String string) {
                return string.equals(fLocalName.toLowerCase());
            }
        }

        private static final int CHARACTER = 0;

        private Map<String, TagHandler> fMap = new HashMap<String, TagHandler>();

        private static final int NEW_LINE = 3;

        private static final char SPACE = 1;

        private static final int SPECIAL_SYMBOL = 2;

        /**
         * Allow saving parameters. 
         * For example we save the number of br elements if we're outside 
         * of a block element so that we can emit an onEmptyLines event.
         */
        private Map<String, Object> fStackParameters = new HashMap<String, Object>(); 
        
        public void add(String tag, TagHandler handler) {
            fMap.put(tag, handler);
        }
        
        public void addAll(Map<String, TagHandler> handlers) {
        	fMap.putAll(handlers);
        }

        private TagContext fPeek;

        WikiScannerContext fScannerContext;

        XhtmlEscapeHandler fEscapeHandler;

        public TagStack(WikiScannerContext context, XhtmlEscapeHandler escapeHandler) {
            fScannerContext = context;
            fEscapeHandler = escapeHandler;
            
            // Pre-initialize stack parameters for performance reason 
            // (so that we don't have to check all the time if they're initialized or not)
            setStackParameter("emptyLinesCount", 0);
            setStackParameter("listStyles", new StringBuffer());
            setStackParameter("quoteDepth", new Integer(0));
        }

        public void beginElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {
            fPeek = new TagContext(fPeek, uri, localName, qName, attributes, this);
            localName = fPeek.getName();
            TagHandler handler = fMap.get(localName);
            fPeek.beginElement(handler);
        }

        public void endElement() {
            fPeek.endElement();
            fPeek = fPeek.fParent;
        }

        private XhtmlCharacterType getCharacterType(char ch) {
            XhtmlCharacterType type = XhtmlCharacterType.CHARACTER;
            switch (ch) {
                case '!':
                case '\'':
                case '#':
                case '$':
                case '%':
                case '&':
                case '(':
                case ')':
                case '*':
                case '+':
                case ',':
                case '-':
                case '.':
                case '/':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                case '[':
                case '\\':
                case ']':
                case '^':
                case '_':
                case '`':
                case '{':
                case '|':
                case '}':
                case '~':
                case '\"':
                    type = XhtmlCharacterType.SPECIAL_SYMBOL;
                    break;
                case ' ':
                case '\t':
                    type = XhtmlCharacterType.SPACE;
                    break;
                case '\n':
                case '\r':
                    type = XhtmlCharacterType.NEW_LINE;
                    break;
                default:
                    break;
            }
            return type;
        }

        public WikiScannerContext getScannerContext() {
            return fScannerContext;
        }

        private void flushStack(Stack<XhtmlCharacter> stack) {
            while (stack.size() > 0) {
                XhtmlCharacter character = stack.remove(0);
                switch (character.getType()) {
                    case ESCAPED:
                        fScannerContext.onEscape("" + character.getCharacter());
                        break;
                    case NEW_LINE:
                        fScannerContext.onNewLine();
                        break;
                    case SPECIAL_SYMBOL:
                        fScannerContext.onSpecialSymbol("" + character.getCharacter());
                        break;
                    case SPACE:
                        StringBuffer spaceBuffer = new StringBuffer(" ");
                        while ((stack.size() > 0) && (stack.firstElement().getType() == XhtmlCharacterType.SPACE)) {
                            stack.remove(0);
                            spaceBuffer.append(' ');
                        }
                        fScannerContext.onSpace(spaceBuffer.toString());
                        break;
                    default:
                        StringBuffer charBuffer = new StringBuffer();
                        charBuffer.append(character.getCharacter());
                        while ((stack.size() > 0) && (stack.firstElement().getType() == XhtmlCharacterType.CHARACTER)) {
                            charBuffer.append(stack.firstElement().getCharacter());
                            stack.remove(0);
                        }
                        fScannerContext.onWord(WikiPageUtil.escapeXmlString(charBuffer.toString()));
                }
            }            
        }
        
        public void onCharacters(char[] array, int start, int length) {
            
            if (!fPeek.isContentContainer())
                return;
            if (!fPeek.appendContent(array, start, length)) {
                Stack<XhtmlCharacter> stack = new Stack<XhtmlCharacter>();
                Map<String, Object> characterContext = new HashMap<String, Object>();
                if (fEscapeHandler != null) {
                	fEscapeHandler.initialize(characterContext);
                }
                for (int i = 0; i < length; i++) {
                    XhtmlCharacter current = new XhtmlCharacter(array[start + i], getCharacterType(array[start + i]));
                    XhtmlCharacter result = current;
                    if (fEscapeHandler != null) {

                        // In order to find the HTML tag being handled we need to find the first non null handler
                        TagContext context = fPeek;
                        TagHandler handler = context.fHandler;
                        while ((handler == null) && (context.getParent() != null)) {
                            context = context.getParent();
                            handler = context.fHandler;
                        }
                        String tag;
                        if (handler == null) {
                            // We haven't found a handler. It means we're inside the top element and we assume we're on an implicit paragraph.
                            tag = "p";
                        } else {
                            tag = context.getLocalName().toLowerCase();
                        }
                        
                        result = fEscapeHandler.handleCharacter(current, stack, tag, characterContext);
                    }
                    stack.push(result);
                }
                
                // Now send the events.
                flushStack(stack);
            }
        }
        
        public void setStackParameter(String name, Object data) {
        	fStackParameters.put(name, data);
        }
        
        public Object getStackParameter(String name) {
        	return fStackParameters.get(name);
        }

    }

    protected String fDocumentSectionUri;

    protected String fDocumentUri;

    protected String fDocumentWikiProperties;

    TagStack fStack;

    /**
     * SAX parsers are allowed to call the characters() method several times in a row.
     * Some parsers have a buffer of 8K (Crimson), others of 16K (Xerces) and others can
     * even call onCharacters() for every single characters! Thus we need to accumulate
     * the characters in a buffer before we process them.
     */
    private StringBuffer fAccumulationBuffer;

    /**
     * @param context
     */
    public XhtmlHandler(WikiScannerContext context, Map<String, TagHandler> extraHandlers, XhtmlEscapeHandler escapeHandler) {
        fStack = new TagStack(context, escapeHandler);
        
        // Register default handlers
        fStack.add("p", new ParagraphTagHandler());
        fStack.add("table", new TableTagHandler());
        fStack.add("tr", new TableRowTagHandler());
        TagHandler handler = new TableDataTagHandler();
        fStack.add("td", handler);
        fStack.add("th", handler);
        handler = new ListTagHandler();
        fStack.add("ul", handler);
        fStack.add("ol", handler);
        fStack.add("li", new ListItemTagHandler());
        fStack.add("dl", new DefinitionListTagHandler());
        fStack.add("dt", new DefinitionTermTagHandler());
        fStack.add("dd", new DefinitionDescriptionTagHandler());
        handler = new HeaderTagHandler();
        fStack.add("h1", handler);
        fStack.add("h2", handler);
        fStack.add("h3", handler);
        fStack.add("h4", handler);
        fStack.add("h5", handler);
        fStack.add("h6", handler);
        fStack.add("hr", new HorizontalLineTagHandler());
        fStack.add("pre", new PreserveTagHandler());
        fStack.add("a", new ReferenceTagHandler());
        handler = new BoldTagHandler();
        fStack.add("strong", handler);
        fStack.add("b", handler);
        handler = new UnderlineTagHandler();
        fStack.add("ins", handler);
        fStack.add("u", handler);
        handler = new StrikedOutTagHandler();
        fStack.add("del", handler);
        fStack.add("strike", handler);
        fStack.add("s", handler);
        handler = new ItalicTagHandler();
        fStack.add("em", handler);
        fStack.add("i", handler);
        fStack.add("sup", new SuperScriptTagHandler());
        fStack.add("sub", new SubScriptTagHandler());
        fStack.add("tt", new TeletypeTagHandler());
        fStack.add("br", new LineBreakTagHandler());
        fStack.add("div", new DivisionTagHandler());
        handler = new QuoteTagHandler();
        fStack.add("blockquote", handler);
        fStack.add("quote", handler);

        // Register extra handlers
        fStack.addAll(extraHandlers);
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] array, int start, int length)
        throws SAXException {
        if (fAccumulationBuffer != null) {
            fAccumulationBuffer.append(array, start, length);
        }
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler#endDocument()
     */
    @Override
    public void endDocument() throws SAXException {
        TagHandler.sendEmptyLines(fStack.fPeek);
        fStack.endElement();
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName)
        throws SAXException {
        if (fAccumulationBuffer != null && fAccumulationBuffer.length() > 0) {
            fStack.onCharacters(fAccumulationBuffer.toString().toCharArray(), 0, fAccumulationBuffer.length());
            fAccumulationBuffer.setLength(0);
        }
        fStack.endElement();
    }

    protected String getHref(Attributes attributes) {
        String value = attributes.getValue("HREF");
        if (value == null)
            value = attributes.getValue("href");
        if (value == null)
            value = attributes.getValue("src");
        if (value == null)
            value = attributes.getValue("SRC");
        return value;
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler#startDocument()
     */
    @Override
    public void startDocument() throws SAXException {
        fStack.beginElement(null, null, null, null);
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(
        String uri,
        String localName,
        String qName,
        Attributes attributes) throws SAXException {
        if (fAccumulationBuffer != null && fAccumulationBuffer.length() > 0) {
            fStack.onCharacters(fAccumulationBuffer.toString().toCharArray(), 0, fAccumulationBuffer.length());
        }
        fAccumulationBuffer = new StringBuffer();
        fStack.beginElement(uri, localName, qName, attributes);
    }
}
