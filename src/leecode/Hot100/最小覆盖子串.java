package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 滑动窗口
 * @date: 2024-07-06 12:51
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    // 输入：s = "ADOBECODEBANC", t = "ABC"
    // 输出："BANC"
    // 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int left = 0;
        int right = 0;
        int valid = 0;
        String ans = "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int m = s.length();
        int len = m + 1;
        // 右边界负责往窗口内添加元素
        while (right < m) {
            char cur = s.charAt(right);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (need.containsKey(cur) && window.get(cur) <= need.get(cur)) {
                valid++;
            }
            // 一旦达到需要的元素个数，就开始收缩左窗口
            while (valid == t.length()) {
                // 更新结果
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                char l = s.charAt(left);
                // 收缩左窗口
                window.put(l, window.get(l) - 1);
                if (need.containsKey(l) && window.get(l) < need.get(l)) {
                    valid--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
