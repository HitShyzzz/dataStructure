package leecode.top50;

import java.util.HashSet;
import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 滑动窗口，右边界不停右移添加元素，左窗口收缩过滤
 * @date: 2024-08-26 20:52
 */
public class 无重复字符的最长子串方法2 {
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
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
