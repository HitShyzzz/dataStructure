package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-20 19:50
 */
public class 找出最长的超赞子字符串 {
    public static void main(String[] args) {
        String s = "3242415";
        System.out.println(longestAwesome(s));
    }

    // 输入：s = "3242415"
    // 输出：5
    public static int longestAwesome(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static boolean check(String s, int i, int j) {
        if ("".equals(s) || i >= j) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int k = i; k <= j; k++) {
            char c = s.charAt(k);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        for (Character c : map.keySet()) {
            int value = map.get(c);
            if (value % 2 != 0) {
                cnt++;
            }
        }
        return cnt == 0 || cnt== 1;
    }
}
