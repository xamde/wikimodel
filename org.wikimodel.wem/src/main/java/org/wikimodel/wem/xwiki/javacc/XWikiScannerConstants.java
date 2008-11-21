/* Generated By:JavaCC: Do not edit this line. XWikiScannerConstants.java */
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
package org.wikimodel.wem.xwiki.javacc;

public interface XWikiScannerConstants {

  int EOF = 0;
  int INTERNAL_VERBATIM_START = 1;
  int INTERNAL_VERBATIM_END = 2;
  int INTERNAL_VERBATIM_CONTENT = 3;
  int INTERNAL_MACRO_START = 4;
  int INTERNAL_MACRO_END = 5;
  int INTERNAL_MACRO_CONTENT = 6;
  int LI = 7;
  int HEADER = 8;
  int ESCAPE = 9;
  int BR = 10;
  int VERBATIM_START = 11;
  int VERBATIM_END = 12;
  int VERBATIM_CONTENT = 13;
  int MACRO_NAME = 14;
  int MACRO_DEF = 15;
  int MACRO_EMPTY = 16;
  int MACRO_START = 17;
  int MACRO_END = 18;
  int MACRO_CONTENT = 19;
  int REFERENCE_IMAGE = 20;
  int REFERENCE = 21;
  int HORLINE = 22;
  int PARAMS = 23;
  int CELL = 24;
  int QUOT_LINE = 25;
  int FORMAT_SYMBOL = 26;
  int NEW_LINE = 27;
  int SPACE = 28;
  int SPECIAL_SYMBOL = 29;
  int CHAR = 30;
  int URI = 31;
  int ALPHA = 32;
  int DIGIT = 33;
  int HEXDIG = 34;
  int URI_GEN_DELIMS = 35;
  int URI_SUB_DELIMS = 36;
  int URI_UNRESERVED = 37;
  int URI_RESERVED = 38;
  int URI_SCHEME = 39;
  int URI_SCHEME_COMPOSITE = 40;
  int URI_PCT_ENCODED = 41;
  int URI_PCHAR_FIRST = 42;
  int URI_PCHAR = 43;
  int URI_QUERY = 44;
  int URI_FRAGMENT = 45;
  int URI_HIER_PART = 46;
  int URI_AUTHORITY = 47;
  int URI_USERINFO = 48;
  int URI_PATH_ABEMPTY = 49;
  int URI_PATH_ABSOLUTE = 50;
  int URI_PATH_ROOTLESS = 51;
  int URI_SEGMENT = 52;
  int URI_SEGMENT_NZ = 53;
  int URI_SEGMENT_NZ_NC = 54;
  int URI_PORT = 55;
  int URI_HOST = 56;
  int URI_REG_NAME = 57;
  int I_ESCAPE = 58;
  int I_LIST_ITEM = 59;
  int I_HEADER_BEGIN = 60;
  int I_HEADER_END = 61;
  int I_HORLINE = 62;
  int I_TABLE_ROW = 63;
  int I_TABLE_CELL = 64;
  int I_REFERENCE = 65;
  int I_VERBATIM_START = 66;
  int I_VERBATIM_INLINE_START = 67;
  int I_MACRO_EMPTY_BLOCK = 68;
  int I_MACRO_BLOCK_START = 69;
  int I_MACRO_EMPTY_INLINE = 70;
  int I_MACRO_INLINE_START = 71;
  int I_FORMAT_SYMBOL = 72;
  int I_BR = 73;
  int I_BLOCK_PARAMS = 74;
  int I_INLINE_PARAMS = 75;
  int I_QUOT_LINE = 76;
  int I_URI = 77;
  int I_NL = 78;
  int I_SPACE = 79;
  int I_WORD = 80;
  int I_SPECIAL_SYMBOL = 81;
  int D_ESCAPE = 82;
  int D_LIST_ITEM = 83;
  int D_HEADER_BEGIN = 84;
  int D_HEADER_END = 85;
  int D_HORLINE = 86;
  int D_TABLE_ROW = 87;
  int D_TABLE_CELL = 88;
  int D_REFERENCE = 89;
  int D_VERBATIM_START = 90;
  int D_VERBATIM_INLINE_START = 91;
  int D_MACRO_EMPTY_BLOCK = 92;
  int D_MACRO_BLOCK_START = 93;
  int D_MACRO_EMPTY_INLINE = 94;
  int D_MACRO_INLINE_START = 95;
  int D_FORMAT_SYMBOL = 96;
  int D_BR = 97;
  int D_BLOCK_PARAMS = 98;
  int D_INLINE_PARAMS = 99;
  int D_QUOT_LINE = 100;
  int D_URI = 101;
  int D_NL = 102;
  int D_SPACE = 103;
  int D_WORD = 104;
  int D_SPECIAL_SYMBOL = 105;

  int VERBATIM_CONTEXT = 0;
  int MACRO_CONTEXT = 1;
  int DEFAULT = 2;
  int INITIAL_CONTEXT = 3;

  String[] tokenImage = {
    "<EOF>",
    "<INTERNAL_VERBATIM_START>",
    "<INTERNAL_VERBATIM_END>",
    "<INTERNAL_VERBATIM_CONTENT>",
    "<INTERNAL_MACRO_START>",
    "<INTERNAL_MACRO_END>",
    "<INTERNAL_MACRO_CONTENT>",
    "<LI>",
    "<HEADER>",
    "<ESCAPE>",
    "\"\\\\\\\\\"",
    "\"{{{\"",
    "\"}}}\"",
    "<VERBATIM_CONTENT>",
    "<MACRO_NAME>",
    "<MACRO_DEF>",
    "<MACRO_EMPTY>",
    "<MACRO_START>",
    "<MACRO_END>",
    "<MACRO_CONTENT>",
    "<REFERENCE_IMAGE>",
    "<REFERENCE>",
    "<HORLINE>",
    "<PARAMS>",
    "<CELL>",
    "<QUOT_LINE>",
    "<FORMAT_SYMBOL>",
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
    "<I_ESCAPE>",
    "<I_LIST_ITEM>",
    "<I_HEADER_BEGIN>",
    "<I_HEADER_END>",
    "<I_HORLINE>",
    "<I_TABLE_ROW>",
    "<I_TABLE_CELL>",
    "<I_REFERENCE>",
    "<I_VERBATIM_START>",
    "<I_VERBATIM_INLINE_START>",
    "<I_MACRO_EMPTY_BLOCK>",
    "<I_MACRO_BLOCK_START>",
    "<I_MACRO_EMPTY_INLINE>",
    "<I_MACRO_INLINE_START>",
    "<I_FORMAT_SYMBOL>",
    "<I_BR>",
    "<I_BLOCK_PARAMS>",
    "<I_INLINE_PARAMS>",
    "<I_QUOT_LINE>",
    "<I_URI>",
    "<I_NL>",
    "<I_SPACE>",
    "<I_WORD>",
    "<I_SPECIAL_SYMBOL>",
    "<D_ESCAPE>",
    "<D_LIST_ITEM>",
    "<D_HEADER_BEGIN>",
    "<D_HEADER_END>",
    "<D_HORLINE>",
    "<D_TABLE_ROW>",
    "<D_TABLE_CELL>",
    "<D_REFERENCE>",
    "<D_VERBATIM_START>",
    "<D_VERBATIM_INLINE_START>",
    "<D_MACRO_EMPTY_BLOCK>",
    "<D_MACRO_BLOCK_START>",
    "<D_MACRO_EMPTY_INLINE>",
    "<D_MACRO_INLINE_START>",
    "<D_FORMAT_SYMBOL>",
    "<D_BR>",
    "<D_BLOCK_PARAMS>",
    "<D_INLINE_PARAMS>",
    "<D_QUOT_LINE>",
    "<D_URI>",
    "<D_NL>",
    "<D_SPACE>",
    "<D_WORD>",
    "<D_SPECIAL_SYMBOL>",
  };

}
