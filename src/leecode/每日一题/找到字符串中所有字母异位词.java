package leecode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/9:37
 * @Description:
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    // 能做，但是会超时！
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return ans;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= m - n; i++) {
            Map<Character, Integer> have = new HashMap<>();
            int valid = 0;// 合法字符
            char c = s.charAt(i);
            if (need.containsKey(c)) {
                String temp = s.substring(i, i + n);
                for (int j = 0; j < temp.length(); j++) {
                    char cur = temp.charAt(j);
                    if (need.containsKey(cur)) {
                        have.put(cur, have.getOrDefault(cur, 0) + 1);
                        if (have.get(cur) <= need.get(cur)) {
                            valid++;
                        }
                        if (valid == n) {
                            ans.add(i);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
