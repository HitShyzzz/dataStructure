package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/9:23
 * @Description:
 */
public class 字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }
            while (valid == s1.length()) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                char cur = s2.charAt(left);
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
        return false;
    }
}
