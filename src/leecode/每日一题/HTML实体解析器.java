package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-23 21:13
 */
public class HTML实体解析器 {
    private static Map<String, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String text = "and I quote: &quot;...&quot;";
        String s = entityParser(text);
        System.out.println(s);
    }

    // 输入：text = "and I quote: &quot;...&quot;"
    // 输出："and I quote: \"...\""
    public static String entityParser(String text) {
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        String reg = "&.*?;";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder(text);
        while (matcher.find()) {
            String key = matcher.group();
            int index = sb1.indexOf(key);
            sb.append(sb1.substring(0, index));
            boolean isMatch = false;
            for (Map.Entry<String, Character> entry : map.entrySet()) {
                String s = entry.getKey();
                char value = entry.getValue();
                if (key.contains(s)) {
                    int i = key.indexOf(s);
                    sb.append(key, 0, i);
                    sb.append(value);
                    sb.append(key.substring(i + s.length()));
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                sb.append(key);
            }
            sb1.delete(0, index + key.length());
        }
        if (!sb1.isEmpty()) {
            sb.append(sb1);
        }
        return sb.toString();
    }
}


