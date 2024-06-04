package leecode.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-03 21:49
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    // 输入: s = "cbaebabacd", p = "abc"
    // 输出: [0,6]
    // 滑动窗口：右边界填充元素，左边界收缩
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        // 右边界填充元素
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }
            // 左边界收缩窗口
            while (valid == p.length()) {
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                    if (window.get(l) < need.get(l)) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
