package leecode.精选TOP面试题;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-06 21:00
 */
public class 无重复字符的最长子串 {
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
        int i = 0;
        while (i < s.length()) {
            if (s.substring(start, i).indexOf(s.charAt(i)) == -1) {
                answer = Math.max(answer, i - start + 1);
                i++;
            } else {
                start++;
            }
        }
        return answer;
    }
}
