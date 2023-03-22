package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/28/17:08
 * @Description:
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int left = 0, right = 0;
        int valid = 0;// 用来记录窗口内包含目标字符串中字符要求的个数
        Map<Character, Integer> window = new HashMap<>();// 窗口内包含目标字符串各个字符的数量
        Map<Character, Integer> need = new HashMap<>();// 目标字符串中需要的各个字符数量
        int len = Integer.MAX_VALUE;// 用来记录最小子串的长度
        String res = "";
        int start = 0;
        // 首先得到目标字符串需要的各个字符个数
        for (char s1 : t.toCharArray()) {
            need.put(s1, need.getOrDefault(s1, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }
            while (valid == t.length()) {
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char cur = s.charAt(left);
                if (need.containsKey(cur)) {
                    window.put(cur, window.get(cur) - 1);
                    if (window.get(cur) < need.get(cur)) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
