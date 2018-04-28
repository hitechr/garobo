package org.hitechr.garobo.console.common.utils;

import java.io.*;
import java.util.BitSet;

/**
 * Created by Administrator on 2015/5/11.
 */
public class StringEscapeUtils {
    private static final BitSet ALPHA = new BitSet(256);
    private static final BitSet ALPHANUM;
    private static final BitSet MARK;
    private static final BitSet RESERVED;
    private static final BitSet UNRESERVED;
    private static int[] HEXADECIMAL;

    static {
        int i;
        for (i = 97; i <= 122; ++i) {
            ALPHA.set(i);
        }

        for (i = 65; i <= 90; ++i) {
            ALPHA.set(i);
        }

        ALPHANUM = new BitSet(256);
        ALPHANUM.or(ALPHA);

        for (i = 48; i <= 57; ++i) {
            ALPHANUM.set(i);
        }

        MARK = new BitSet(256);
        MARK.set(45);
        MARK.set(95);
        MARK.set(46);
        MARK.set(33);
        MARK.set(126);
        MARK.set(42);
        MARK.set(39);
        MARK.set(40);
        MARK.set(41);
        RESERVED = new BitSet(256);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        UNRESERVED = new BitSet(256);
        UNRESERVED.or(ALPHANUM);
        UNRESERVED.or(MARK);
        HEXADECIMAL = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    }

    public StringEscapeUtils() {
    }

    public static String escapeJava(String value) {
        return escapeJavaStyleString(value, false, false);
    }

    public static String escapeJava(String value, boolean strict) {
        return escapeJavaStyleString(value, false, strict);
    }

    public static void escapeJava(String value, Writer out) throws IOException {
        escapeJavaStyleString(value, false, out, false);
    }

    public static void escapeJava(String value, Writer out, boolean strict) throws IOException {
        escapeJavaStyleString(value, false, out, strict);
    }

    public static String escapeJavaScript(String value) {
        return escapeJavaStyleString(value, true, false);
    }

    public static String escapeJavaScript(String value, boolean strict) {
        return escapeJavaStyleString(value, true, strict);
    }

    public static void escapeJavaScript(String value, Writer out) throws IOException {
        escapeJavaStyleString(value, true, out, false);
    }

    public static void escapeJavaScript(String value, Writer out, boolean strict) throws IOException {
        escapeJavaStyleString(value, true, out, strict);
    }

    private static String escapeJavaStyleString(String value, boolean escapeSingleQuotes, boolean strict) {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length() * 2);
                return escapeJavaStyleString(value, escapeSingleQuotes, e, strict) ? e.toString() : value;
            } catch (IOException var4) {
                return value;
            }
        }
    }

    private static boolean escapeJavaStyleString(String value, boolean escapeSingleQuote, Writer out, boolean strict) throws IOException {
        boolean needToChange = false;
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (value == null) {
            return needToChange;
        } else {
            int length = value.length();

            for (int i = 0; i < length; ++i) {
                char ch = value.charAt(i);
                if (ch < 32) {
                    switch (ch) {
                        case '\b':
                            out.write(92);
                            out.write(98);
                            break;
                        case '\t':
                            out.write(92);
                            out.write(116);
                            break;
                        case '\n':
                            out.write(92);
                            out.write(110);
                            break;
                        case '\u000b':
                        default:
                            if (ch > 15) {
                                out.write("\\u00" + Integer.toHexString(ch).toUpperCase());
                            } else {
                                out.write("\\u000" + Integer.toHexString(ch).toUpperCase());
                            }
                            break;
                        case '\f':
                            out.write(92);
                            out.write(102);
                            break;
                        case '\r':
                            out.write(92);
                            out.write(114);
                    }

                    needToChange = true;
                } else if (strict && ch > 255) {
                    if (ch > 4095) {
                        out.write("\\u" + Integer.toHexString(ch).toUpperCase());
                    } else {
                        out.write("\\u0" + Integer.toHexString(ch).toUpperCase());
                    }

                    needToChange = true;
                } else {
                    switch (ch) {
                        case '\"':
                            out.write(92);
                            out.write(34);
                            needToChange = true;
                            break;
                        case '\'':
                            if (escapeSingleQuote) {
                                out.write(92);
                                needToChange = true;
                            }

                            out.write(39);
                            break;
                        case '\\':
                            out.write(92);
                            out.write(92);
                            needToChange = true;
                            break;
                        default:
                            out.write(ch);
                    }
                }
            }

            return needToChange;
        }
    }

    public static String unescapeJava(String value) {
        return unescapeJavaStyleString(value);
    }

    public static void unescapeJava(String value, Writer out) throws IOException {
        unescapeJavaStyleString(value, out);
    }

    public static String unescapeJavaScript(String value) {
        return unescapeJavaStyleString(value);
    }

    public static void unescapeJavaScript(String value, Writer out) throws IOException {
        unescapeJavaStyleString(value, out);
    }

    private static String unescapeJavaStyleString(String value) {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length());
                return unescapeJavaStyleString(value, e) ? e.toString() : value;
            } catch (IOException var2) {
                return value;
            }
        }
    }

    private static boolean unescapeJavaStyleString(String value, Writer out) throws IOException {
        boolean needToChange = false;
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (value == null) {
            return needToChange;
        } else {
            int length = value.length();
            StringBuffer unicode = new StringBuffer(4);
            boolean hadSlash = false;
            boolean inUnicode = false;

            for (int i = 0; i < length; ++i) {
                char ch = value.charAt(i);
                if (inUnicode) {
                    unicode.append(ch);
                    if (unicode.length() == 4) {
                        String unicodeStr = unicode.toString();

                        try {
                            int e = Integer.parseInt(unicodeStr, 16);
                            out.write((char) e);
                            unicode.setLength(0);
                            inUnicode = false;
                            hadSlash = false;
                            needToChange = true;
                        } catch (NumberFormatException var11) {
                            out.write("\\u" + unicodeStr);
                        }
                    }
                } else if (hadSlash) {
                    hadSlash = false;
                    switch (ch) {
                        case '\"':
                            out.write(34);
                            needToChange = true;
                            break;
                        case '\'':
                            out.write(39);
                            needToChange = true;
                            break;
                        case '\\':
                            out.write(92);
                            needToChange = true;
                            break;
                        case 'b':
                            out.write(8);
                            needToChange = true;
                            break;
                        case 'f':
                            out.write(12);
                            needToChange = true;
                            break;
                        case 'n':
                            out.write(10);
                            needToChange = true;
                            break;
                        case 'r':
                            out.write(13);
                            needToChange = true;
                            break;
                        case 't':
                            out.write(9);
                            needToChange = true;
                            break;
                        case 'u':
                            inUnicode = true;
                            break;
                        default:
                            out.write(ch);
                    }
                } else if (ch == 92) {
                    hadSlash = true;
                } else {
                    out.write(ch);
                }
            }

            if (hadSlash) {
                out.write(92);
            }

            return needToChange;
        }
    }

    public static String escapeHtml(String value) {
        return escapeEntities(Entities.HTML40, value);
    }

    public static String escapeCombinedCookie(String value) {
        return escapeEntities(Entities.COMBINED_COOKIE, value);
    }

    public static String unescapeCombinedCookie(String value) {
        return unescapeEntities(Entities.COMBINED_COOKIE, value);
    }

    public static void escapeHtml(String value, Writer out) throws IOException {
        escapeEntities(Entities.HTML40, value, out);
    }

    public static String escapeXml(String value) {
        return escapeEntities(Entities.XML, value);
    }

    public static void escapeXml(String value, Writer out) throws IOException {
        escapeEntities(Entities.XML, value, out);
    }

    public static String escapeEntities(Entities entities, String value) {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length());
                return escapeEntitiesInternal(entities, value, e) ? e.toString() : value;
            } catch (IOException var3) {
                return value;
            }
        }
    }

    public static void escapeEntities(Entities entities, String value, Writer out) throws IOException {
        escapeEntitiesInternal(entities, value, out);
    }

    public static String unescapeHtml(String value) {
        return unescapeEntities(Entities.HTML40, value);
    }

    public static void unescapeHtml(String value, Writer out) throws IOException {
        unescapeEntities(Entities.HTML40, value, out);
    }

    public static String unescapeXml(String value) {
        return unescapeEntities(Entities.XML, value);
    }

    public static void unescapeXml(String value, Writer out) throws IOException {
        unescapeEntities(Entities.XML, value, out);
    }

    public static String unescapeEntities(Entities entities, String value) {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length());
                return unescapeEntitiesInternal(entities, value, e) ? e.toString() : value;
            } catch (IOException var3) {
                return value;
            }
        }
    }

    public static void unescapeEntities(Entities entities, String value, Writer out) throws IOException {
        unescapeEntitiesInternal(entities, value, out);
    }

    private static boolean escapeEntitiesInternal(Entities entities, String value, Writer out) throws IOException {
        boolean needChange = false;
        if (entities == null) {
            throw new IllegalArgumentException("The Entities must not be null");
        } else if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (value == null) {
            return needChange;
        } else {
            for (int i = 0; i < value.length(); ++i) {
                char ch = value.charAt(i);
                String entityName = entities.getEntityName(ch);
                if (entityName == null) {
                    out.write(ch);
                } else {
                    out.write(38);
                    out.write(entityName);
                    out.write(59);
                    needChange = true;
                }
            }

            return needChange;
        }
    }

    private static boolean unescapeEntitiesInternal(Entities entities, String value, Writer out) throws IOException {
        boolean needToChange = false;
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (value == null) {
            return needToChange;
        } else {
            for (int i = 0; i < value.length(); ++i) {
                char ch = value.charAt(i);
                if (ch == 38) {
                    int semi = value.indexOf(59, i + 1);
                    if (semi != -1 && i + 1 < semi - 1) {
                        if (value.charAt(i + 1) == 35) {
                            int entityName = i + 2;
                            byte entityValue = 10;
                            if (entityName >= semi - 1) {
                                out.write(ch);
                                out.write(35);
                                ++i;
                                continue;
                            }

                            char firstChar = value.charAt(entityName);
                            if (firstChar == 120 || firstChar == 88) {
                                ++entityName;
                                entityValue = 16;
                                if (entityName >= semi - 1) {
                                    out.write(ch);
                                    out.write(35);
                                    ++i;
                                    continue;
                                }
                            }

                            try {
                                int e = Integer.parseInt(value.substring(entityName, semi), entityValue);
                                out.write(e);
                                needToChange = true;
                            } catch (NumberFormatException var11) {
                                out.write(ch);
                                out.write(35);
                                ++i;
                                continue;
                            }
                        } else {
                            String var12 = value.substring(i + 1, semi);
                            int var13 = -1;
                            if (entities != null) {
                                var13 = entities.getEntityValue(var12);
                            }

                            if (var13 == -1) {
                                out.write(38);
                                out.write(var12);
                                out.write(59);
                            } else {
                                out.write(var13);
                                needToChange = true;
                            }
                        }

                        i = semi;
                    } else {
                        out.write(ch);
                    }
                } else {
                    out.write(ch);
                }
            }

            return needToChange;
        }
    }

    public static String escapeSql(String value) {
        return StringUtils.replace(value, "\'", "\'\'");
    }

    public static void escapeSql(String value, Writer out) throws IOException {
        String result = StringUtils.replace(value, "\'", "\'\'");
        if (result != null) {
            out.write(result);
        }

    }

    public static String escapeURL(String value) {
        try {
            return escapeURLInternal(value, (String) null, true);
        } catch (UnsupportedEncodingException var2) {
            return value;
        }
    }

    public static String escapeURL(String value, String encoding) throws UnsupportedEncodingException {
        return escapeURLInternal(value, encoding, true);
    }

    public static String escapeURL(String value, String encoding, boolean strict) throws UnsupportedEncodingException {
        return escapeURLInternal(value, encoding, strict);
    }

    public static void escapeURL(String value, String encoding, Writer out) throws IOException {
        escapeURLInternal(value, encoding, out, true);
    }

    public static void escapeURL(String value, String encoding, Writer out, boolean strict) throws IOException {
        escapeURLInternal(value, encoding, out, strict);
    }

    private static String escapeURLInternal(String value, String encoding, boolean strict) throws UnsupportedEncodingException {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length());
                return escapeURLInternal(value, encoding, e, strict) ? e.toString() : value;
            } catch (UnsupportedEncodingException var4) {
                throw var4;
            } catch (IOException var5) {
                return value;
            }
        }
    }

    private static boolean escapeURLInternal(String value, String encoding, Writer out, boolean strict) throws IOException {
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }

        boolean needToChange = false;
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (value == null) {
            return needToChange;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(10);
            OutputStreamWriter writer = new OutputStreamWriter(baos, encoding);

            for (int i = 0; i < value.length(); ++i) {
                char ch = value.charAt(i);
                if (isSafeCharacter(ch, strict)) {
                    out.write(ch);
                } else if (ch == 32) {
                    out.write(43);
                    needToChange = true;
                } else {
                    try {
                        writer.write(ch);
                        writer.flush();
                    } catch (IOException var14) {
                        baos.reset();
                        continue;
                    }

                    byte[] bytes = baos.toByteArray();

                    for (int j = 0; j < bytes.length; ++j) {
                        byte toEscape = bytes[j];
                        out.write(37);
                        int low = toEscape & 15;
                        int high = (toEscape & 240) >> 4;
                        out.write(HEXADECIMAL[high]);
                        out.write(HEXADECIMAL[low]);
                    }

                    baos.reset();
                    needToChange = true;
                }
            }

            return needToChange;
        }
    }

    private static boolean isSafeCharacter(int ch, boolean strict) {
        return strict ? UNRESERVED.get(ch) : ch > 32 && !RESERVED.get(ch) && !Character.isWhitespace((char) ch);
    }

    public static String unescapeURL(String value) {
        try {
            return unescapeURLInternal(value, (String) null);
        } catch (UnsupportedEncodingException var2) {
            return value;
        }
    }

    public static String unescapeURL(String value, String encoding) throws UnsupportedEncodingException {
        return unescapeURLInternal(value, encoding);
    }

    public static void unescapeURL(String value, String encoding, Writer out) throws IOException {
        unescapeURLInternal(value, encoding, out);
    }

    private static String unescapeURLInternal(String value, String encoding) throws UnsupportedEncodingException {
        if (value == null) {
            return null;
        } else {
            try {
                StringWriter e = new StringWriter(value.length());
                return unescapeURLInternal(value, encoding, e) ? e.toString() : value;
            } catch (UnsupportedEncodingException var3) {
                throw var3;
            } catch (IOException var4) {
                return value;
            }
        }
    }

    private static boolean unescapeURLInternal(String value, String encoding, Writer out) throws IOException {
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }

        boolean needChange = false;
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else {
            int length = value.length();
            byte[] buffer = (byte[]) null;
            int pos = 0;

            for (int i = 0; i < length; ++i) {
                char ch = value.charAt(i);
                if (ch < 256) {
                    if (buffer == null) {
                        buffer = new byte[length - i];
                    }

                    switch (ch) {
                        case '%':
                            if (i + 2 < length) {
                                try {
                                    buffer[pos] = (byte) Integer.parseInt(value.substring(i + 1, i + 3), 16);
                                    ++pos;
                                    i += 2;
                                    needChange = true;
                                } catch (NumberFormatException var10) {
                                    buffer[pos++] = (byte) ch;
                                }
                            } else {
                                buffer[pos++] = (byte) ch;
                            }
                            break;
                        case '+':
                            buffer[pos++] = 32;
                            needChange = true;
                            break;
                        default:
                            buffer[pos++] = (byte) ch;
                    }
                } else {
                    if (pos > 0) {
                        out.write(new String(buffer, 0, pos, encoding));
                        pos = 0;
                    }

                    out.write(ch);
                }
            }

            if (pos > 0) {
                out.write(new String(buffer, 0, pos, encoding));
                boolean var11 = false;
            }

            return needChange;
        }
    }
}

