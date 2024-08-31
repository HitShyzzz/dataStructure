package leecode.top50;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * 滑动窗口，右边界不停右移添加元素，左窗口收缩过滤
 * @date: 2024-08-26 20:52
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    // 输入: s = "pwwkew"
    // 输出: 3
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int ans = 0;
        int l = 0;
        // map记录字符出现的上一次下标
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
                map.put(c, i);
            }
            map.put(c, i);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
