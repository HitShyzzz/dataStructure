package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 18:01
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    // 输入: s = "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // key是s[i]字符，value是s[i]字符上次出现的下标
        int l = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                // 如果c在窗口内，l=map.get(c)+1
                // 如果c不在窗口内，l就不动
                // 考虑例子abba即可
                l = Math.max(l, map.get(c) + 1);
            }
            map.put(c, r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
