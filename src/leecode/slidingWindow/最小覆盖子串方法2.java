package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/03/9:25
 * @Description:
 */
public class 最小覆盖子串方法2 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }

    /**
     * 还是得滑动窗口，先移动右指针直到包含t中所有字符，然后再去收缩左指针来得到最短的长度
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 用来记录窗口内出现的字符和次数，便于判断是否包含了需要的字符和重复次数
        Map<Character, Integer> window = new HashMap<>();
        // 用来记录t中出现的字符和重复的次数
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 滑动窗口的左右指针
        int l = 0;
        int r = 0;
        int valid = 0;// 记录窗口内有效字符的个数
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }
            // 此时窗口内已经包含了全部需要的字符，需要右移动左指针来收缩窗口
            while (valid == t.length()) {
                if (r - l + 1 < minLen) {
                    start = l;
                    minLen = r - l + 1;
                }
                char cur = s.charAt(l);
                if (need.containsKey(cur)) {
                    window.put(cur, window.get(cur) - 1);
                    if (window.get(cur) < need.get(cur)) {
                        valid--;
                    }
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
