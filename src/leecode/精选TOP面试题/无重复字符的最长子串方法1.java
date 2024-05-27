package leecode.精选TOP面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-06 21:00
 */
public class 无重复字符的最长子串方法1 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    // 输入: s = "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int start = 0;
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (windows.containsKey(c)) {
                // 如果上次出现的字符在窗口内，那么起始字符下标就要在上次出现字符的下标+1
                // 如果上次出现的字符不在窗口内，那么起始字符下标可不动
                start = Math.max(start, windows.get(c) + 1);
            }
            windows.put(c, i);
            answer = Math.max(answer, i - start + 1);
        }
        return answer;
    }
}
