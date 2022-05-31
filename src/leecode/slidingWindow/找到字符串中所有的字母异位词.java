package leecode.slidingWindow;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/28/15:56
 * @Description:
 */
public class 找到字符串中所有的字母异位词 {
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> list = findAnagrams(s, p);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            if (need.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)) <= need.get(s.charAt(right))) {
                    valid++;
                }
            }
            while (valid == p.length()) {
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                char c = s.charAt(left);
                if (need.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < need.get(c)) {
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
