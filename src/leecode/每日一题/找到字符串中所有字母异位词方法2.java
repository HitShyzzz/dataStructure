package leecode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/10:19
 * @Description:
 */
public class 找到字符串中所有字母异位词方法2 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    // 滑动窗口，右边窗口先一直加，直到满足要求，再利用左边窗口进行收缩，
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return ans;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;// 左边窗口
        int right = 0;// 右边窗口
        int valid = 0;
        while (right < m) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }
            while (valid == n) {
                if (right - left + 1 == n) {
                    ans.add(left);
                }
                char cur = s.charAt(left);
                if (need.containsKey(cur)) {
                    // 排除窗口内多余的有效字符
                    window.put(cur, window.get(cur) - 1);
                    if (window.get(cur) < need.get(cur)) {
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
