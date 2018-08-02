package org.hitechr.garobo.console.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/4/27.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private StringUtils() {
    }

    public static String trimSbc(String tarStr) {
        if (isEmpty(tarStr)) {
            return tarStr;
        } else {
            for (tarStr = tarStr.trim(); tarStr.startsWith("　"); tarStr = tarStr.substring(1, tarStr.length()).trim()) {
                ;
            }
            while (tarStr.endsWith("　")) {
                tarStr = tarStr.substring(0, tarStr.length() - 1).trim();
            }
            return tarStr;
        }
    }

    public static String change(String htmlStr) {
        if (isBlank(htmlStr)) {
            return htmlStr;
        } else {
            String temp2 = "";
            String regEx_a = "(<\\s*?(a|A)\\s*?>?[\\s\\S]*?<?[\\s]*?\\/[\\s]*?(a|A)[\\s]*?>)";
            String regEx_href = "((href|HREF)\\s*=\\s*(\"|\'|)(http://)?\\w+\\.360buy\\.com[\\s\\S]*?)";
            String regEx_href_content = "(href=(\"(http:\\/\\/|\\.\\/|\\/)?[\\s\\S]*?\")|href=(\'(http:\\/\\/|\\.\\/|\\/)?[\\s\\S]*?\'))";
            String regEx_script = "(<[\\s]*?(script|SCRIPT)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(script|SCRIPT)[\\s]*?>)";
            String regEx_object = "(<[\\s]*?(object|OBJECT)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(object|OBJECT)[\\s]*?>)";
            String regEx_frame = "(<[\\s]*?(frame|FRAME)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(frame|FRAME)[\\s]*?>)";
            String regEx_iframe = "(<[\\s]*?(iframe|IFRAME)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(iframe|IFRAME)[\\s]*?>)";
            String regEx_form = "(<[\\s]*?\\/?[\\s]*?form[^>]*?>)";
            String regEx_input = "(<[\\s]*?\\/?[\\s]*?input[^>]*?>)";
            String regEx_textarea = "(<[\\s]*?\\/?[\\s]*?textarea[^>]*?>)";
            String regEx_select = "(<[\\s]*?\\/?[\\s]*?select[^>]*?>)";
            String regEx_option = "(<[\\s]*?\\/?[\\s]*?option[^>]*?>)";
            String regEx_button = "(<[\\s]*?\\/?[\\s]*?button[^>]*?>)";
            Pattern p_script = Pattern.compile(regEx_script, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            String temp = m_script.replaceAll(" ");
            Pattern p_object = Pattern.compile(regEx_object, 2);
            Matcher m_object = p_object.matcher(temp);
            temp = m_object.replaceAll(" ");
            Pattern p_frame = Pattern.compile(regEx_frame, 2);
            Matcher m_frame = p_frame.matcher(temp);
            temp = m_frame.replaceAll(" ");
            Pattern p_iframe = Pattern.compile(regEx_iframe, 2);
            Matcher m_iframe = p_iframe.matcher(temp);
            temp = m_iframe.replaceAll(" ");
            Pattern p_a = Pattern.compile(regEx_a, 2);
            Matcher m_a = p_a.matcher(temp);
            Pattern p_form = Pattern.compile(regEx_form, 2);
            Matcher m_form = p_form.matcher(temp);
            temp = m_form.replaceAll(" ");
            Pattern p_input = Pattern.compile(regEx_input, 2);
            Matcher m_input = p_input.matcher(temp);
            temp = m_input.replaceAll(" ");
            Pattern p_textarea = Pattern.compile(regEx_textarea, 2);
            Matcher m_textarea = p_textarea.matcher(temp);
            temp = m_textarea.replaceAll(" ");
            Pattern p_select = Pattern.compile(regEx_select, 2);
            Matcher m_select = p_select.matcher(temp);
            temp = m_select.replaceAll(" ");
            Pattern p_option = Pattern.compile(regEx_option, 2);
            Matcher m_option = p_option.matcher(temp);
            temp = m_option.replaceAll(" ");
            Pattern p_button = Pattern.compile(regEx_button, 2);
            Matcher m_button = p_button.matcher(temp);
            temp = m_button.replaceAll(" ");
            temp2 = temp;
            Pattern p_href = Pattern.compile(regEx_href, 2);

            while (m_a.find()) {
                String sb = null;
                sb = m_a.group(0);
                Matcher m_href = p_href.matcher(sb);
                if (!m_href.find()) {
                    Pattern p_content = Pattern.compile(regEx_href_content, 2);

                    String change;
                    for (Matcher m_content = p_content.matcher(sb); m_content.find(); temp2 = stringReplace(temp2, change, "href=\"#\"")) {
                        change = null;
                        change = m_content.group(0);
                    }
                }
            }

            return temp2;
        }
    }

    public static String stringReplace(String sourceString, String toReplaceString, String replaceString) {
        String returnString = sourceString;
        int stringLength = 0;
        if (toReplaceString != null) {
            stringLength = toReplaceString.length();
        }

        if (sourceString != null && sourceString.length() >= stringLength) {
            boolean max = false;
            String S4 = " ";

            for (int i = 0; i < sourceString.length(); ++i) {
                int var9 = i + toReplaceString.length() > sourceString.length() ? sourceString.length() : i + stringLength;
                String S3 = sourceString.substring(i, var9);
                if (!S3.equals(toReplaceString)) {
                    S4 = S4 + S3.substring(0, 1);
                } else {
                    S4 = S4 + replaceString;
                    i += stringLength - 1;
                }
            }

            returnString = S4;
        }

        return returnString;
    }


}
