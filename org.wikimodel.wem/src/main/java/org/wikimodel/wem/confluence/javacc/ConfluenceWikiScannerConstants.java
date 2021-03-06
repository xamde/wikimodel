/* Generated By:JavaCC: Do not edit this line. ConfluenceWikiScannerConstants.java */
/*******************************************************************************
 * Copyright (c) 2005,2007 Cognium Systems SA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, Version 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Contributors:
 *     Cognium Systems SA - initial API and implementation
 *******************************************************************************/
package org.wikimodel.wem.confluence.javacc;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ConfluenceWikiScannerConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int INTERNAL_MACRO = 1;
  /** RegularExpression Id. */
  int INTERNAL_MACRO_CONTENT = 2;
  /** RegularExpression Id. */
  int LI = 3;
  /** RegularExpression Id. */
  int LIST_ITEM = 4;
  /** RegularExpression Id. */
  int HEADER = 5;
  /** RegularExpression Id. */
  int VERBATIM = 6;
  /** RegularExpression Id. */
  int REFERENCE = 7;
  /** RegularExpression Id. */
  int HORLINE = 8;
  /** RegularExpression Id. */
  int ESCAPED = 9;
  /** RegularExpression Id. */
  int BR = 10;
  /** RegularExpression Id. */
  int CELL = 11;
  /** RegularExpression Id. */
  int QUOT_BLOCK = 12;
  /** RegularExpression Id. */
  int MACRO_PARAMS = 13;
  /** RegularExpression Id. */
  int QUOT_BLOCK_MACRO = 14;
  /** RegularExpression Id. */
  int MACRO = 15;
  /** RegularExpression Id. */
  int MACRO_CONTENT = 16;
  /** RegularExpression Id. */
  int MACRO_BLOCK = 17;
  /** RegularExpression Id. */
  int FORMAT_SYMBOL = 18;
  /** RegularExpression Id. */
  int SPECIAL_SYMBOLS = 19;
  /** RegularExpression Id. */
  int NEW_LINE = 20;
  /** RegularExpression Id. */
  int SPACE = 21;
  /** RegularExpression Id. */
  int SPECIAL_SYMBOL = 22;
  /** RegularExpression Id. */
  int CHAR = 23;
  /** RegularExpression Id. */
  int URI = 24;
  /** RegularExpression Id. */
  int ALPHA = 25;
  /** RegularExpression Id. */
  int DIGIT = 26;
  /** RegularExpression Id. */
  int HEXDIG = 27;
  /** RegularExpression Id. */
  int URI_GEN_DELIMS = 28;
  /** RegularExpression Id. */
  int URI_SUB_DELIMS = 29;
  /** RegularExpression Id. */
  int URI_UNRESERVED = 30;
  /** RegularExpression Id. */
  int URI_RESERVED = 31;
  /** RegularExpression Id. */
  int URI_SCHEME = 32;
  /** RegularExpression Id. */
  int URI_SCHEME_COMPOSITE = 33;
  /** RegularExpression Id. */
  int URI_PCT_ENCODED = 34;
  /** RegularExpression Id. */
  int URI_PCHAR_FIRST = 35;
  /** RegularExpression Id. */
  int URI_PCHAR = 36;
  /** RegularExpression Id. */
  int URI_QUERY = 37;
  /** RegularExpression Id. */
  int URI_FRAGMENT = 38;
  /** RegularExpression Id. */
  int URI_HIER_PART = 39;
  /** RegularExpression Id. */
  int URI_AUTHORITY = 40;
  /** RegularExpression Id. */
  int URI_USERINFO = 41;
  /** RegularExpression Id. */
  int URI_PATH_ABEMPTY = 42;
  /** RegularExpression Id. */
  int URI_PATH_ABSOLUTE = 43;
  /** RegularExpression Id. */
  int URI_PATH_ROOTLESS = 44;
  /** RegularExpression Id. */
  int URI_SEGMENT = 45;
  /** RegularExpression Id. */
  int URI_SEGMENT_NZ = 46;
  /** RegularExpression Id. */
  int URI_SEGMENT_NZ_NC = 47;
  /** RegularExpression Id. */
  int URI_PORT = 48;
  /** RegularExpression Id. */
  int URI_HOST = 49;
  /** RegularExpression Id. */
  int URI_REG_NAME = 50;
  /** RegularExpression Id. */
  int I_TABLE_ROW = 51;
  /** RegularExpression Id. */
  int I_TABLE_CELL = 52;
  /** RegularExpression Id. */
  int I_LIST_ITEM = 53;
  /** RegularExpression Id. */
  int I_HEADER = 54;
  /** RegularExpression Id. */
  int I_VERBATIM_BLOCK = 55;
  /** RegularExpression Id. */
  int I_HORLINE = 56;
  /** RegularExpression Id. */
  int I_VERBATIM_INLINE = 57;
  /** RegularExpression Id. */
  int I_REFERENCE = 58;
  /** RegularExpression Id. */
  int I_QUOT_BLOCK = 59;
  /** RegularExpression Id. */
  int I_QUOT_BLOCK_MACRO = 60;
  /** RegularExpression Id. */
  int I_BR = 61;
  /** RegularExpression Id. */
  int I_MACRO_BLOCK_START = 62;
  /** RegularExpression Id. */
  int I_MACRO_EMPTY_BLOCK = 63;
  /** RegularExpression Id. */
  int I_MACRO_INLINE_START = 64;
  /** RegularExpression Id. */
  int I_MACRO_EMPTY_INLINE = 65;
  /** RegularExpression Id. */
  int I_ESCAPED = 66;
  /** RegularExpression Id. */
  int I_FORMAT_SYMBOL = 67;
  /** RegularExpression Id. */
  int I_SPECIAL_SYMBOLS = 68;
  /** RegularExpression Id. */
  int I_URI = 69;
  /** RegularExpression Id. */
  int I_NL = 70;
  /** RegularExpression Id. */
  int I_SPACE = 71;
  /** RegularExpression Id. */
  int I_WORD = 72;
  /** RegularExpression Id. */
  int I_SPECIAL_SYMBOL = 73;
  /** RegularExpression Id. */
  int D_TABLE_ROW = 74;
  /** RegularExpression Id. */
  int D_TABLE_CELL = 75;
  /** RegularExpression Id. */
  int D_LIST_ITEM = 76;
  /** RegularExpression Id. */
  int D_HEADER = 77;
  /** RegularExpression Id. */
  int D_VERBATIM_BLOCK = 78;
  /** RegularExpression Id. */
  int D_HORLINE = 79;
  /** RegularExpression Id. */
  int D_VERBATIM_INLINE = 80;
  /** RegularExpression Id. */
  int D_REFERENCE = 81;
  /** RegularExpression Id. */
  int D_QUOT_BLOCK = 82;
  /** RegularExpression Id. */
  int D_QUOT_BLOCK_MACRO = 83;
  /** RegularExpression Id. */
  int D_BR = 84;
  /** RegularExpression Id. */
  int D_MACRO_BLOCK_START = 85;
  /** RegularExpression Id. */
  int D_MACRO_EMPTY_BLOCK = 86;
  /** RegularExpression Id. */
  int D_MACRO_INLINE_START = 87;
  /** RegularExpression Id. */
  int D_MACRO_EMPTY_INLINE = 88;
  /** RegularExpression Id. */
  int D_ESCAPED = 89;
  /** RegularExpression Id. */
  int D_FORMAT_SYMBOL = 90;
  /** RegularExpression Id. */
  int D_SPECIAL_SYMBOLS = 91;
  /** RegularExpression Id. */
  int D_URI = 92;
  /** RegularExpression Id. */
  int D_NL = 93;
  /** RegularExpression Id. */
  int D_SPACE = 94;
  /** RegularExpression Id. */
  int D_WORD = 95;
  /** RegularExpression Id. */
  int D_SPECIAL_SYMBOL = 96;

  /** Lexical state. */
  int MACRO_CONTEXT = 0;
  /** Lexical state. */
  int DEFAULT = 1;
  /** Lexical state. */
  int INITIAL_CONTEXT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<INTERNAL_MACRO>",
    "<INTERNAL_MACRO_CONTENT>",
    "<LI>",
    "<LIST_ITEM>",
    "<HEADER>",
    "<VERBATIM>",
    "<REFERENCE>",
    "<HORLINE>",
    "<ESCAPED>",
    "\"\\\\\\\\\"",
    "<CELL>",
    "<QUOT_BLOCK>",
    "<MACRO_PARAMS>",
    "<QUOT_BLOCK_MACRO>",
    "<MACRO>",
    "<MACRO_CONTENT>",
    "<MACRO_BLOCK>",
    "<FORMAT_SYMBOL>",
    "<SPECIAL_SYMBOLS>",
    "<NEW_LINE>",
    "<SPACE>",
    "<SPECIAL_SYMBOL>",
    "<CHAR>",
    "<URI>",
    "<ALPHA>",
    "<DIGIT>",
    "<HEXDIG>",
    "<URI_GEN_DELIMS>",
    "<URI_SUB_DELIMS>",
    "<URI_UNRESERVED>",
    "<URI_RESERVED>",
    "<URI_SCHEME>",
    "<URI_SCHEME_COMPOSITE>",
    "<URI_PCT_ENCODED>",
    "<URI_PCHAR_FIRST>",
    "<URI_PCHAR>",
    "<URI_QUERY>",
    "<URI_FRAGMENT>",
    "<URI_HIER_PART>",
    "<URI_AUTHORITY>",
    "<URI_USERINFO>",
    "<URI_PATH_ABEMPTY>",
    "<URI_PATH_ABSOLUTE>",
    "<URI_PATH_ROOTLESS>",
    "<URI_SEGMENT>",
    "<URI_SEGMENT_NZ>",
    "<URI_SEGMENT_NZ_NC>",
    "<URI_PORT>",
    "<URI_HOST>",
    "<URI_REG_NAME>",
    "<I_TABLE_ROW>",
    "<I_TABLE_CELL>",
    "<I_LIST_ITEM>",
    "<I_HEADER>",
    "<I_VERBATIM_BLOCK>",
    "<I_HORLINE>",
    "<I_VERBATIM_INLINE>",
    "<I_REFERENCE>",
    "<I_QUOT_BLOCK>",
    "<I_QUOT_BLOCK_MACRO>",
    "<I_BR>",
    "<I_MACRO_BLOCK_START>",
    "<I_MACRO_EMPTY_BLOCK>",
    "<I_MACRO_INLINE_START>",
    "<I_MACRO_EMPTY_INLINE>",
    "<I_ESCAPED>",
    "<I_FORMAT_SYMBOL>",
    "<I_SPECIAL_SYMBOLS>",
    "<I_URI>",
    "<I_NL>",
    "<I_SPACE>",
    "<I_WORD>",
    "<I_SPECIAL_SYMBOL>",
    "<D_TABLE_ROW>",
    "<D_TABLE_CELL>",
    "<D_LIST_ITEM>",
    "<D_HEADER>",
    "<D_VERBATIM_BLOCK>",
    "<D_HORLINE>",
    "<D_VERBATIM_INLINE>",
    "<D_REFERENCE>",
    "<D_QUOT_BLOCK>",
    "<D_QUOT_BLOCK_MACRO>",
    "<D_BR>",
    "<D_MACRO_BLOCK_START>",
    "<D_MACRO_EMPTY_BLOCK>",
    "<D_MACRO_INLINE_START>",
    "<D_MACRO_EMPTY_INLINE>",
    "<D_ESCAPED>",
    "<D_FORMAT_SYMBOL>",
    "<D_SPECIAL_SYMBOLS>",
    "<D_URI>",
    "<D_NL>",
    "<D_SPACE>",
    "<D_WORD>",
    "<D_SPECIAL_SYMBOL>",
  };

}
