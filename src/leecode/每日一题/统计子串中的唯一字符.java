package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-26 14:39
 */
public class 统计子串中的唯一字符 {
    public static void main(String[] args) {
        String s = "LEETCODE";
        int i = uniqueLetterString(s);
        System.out.println(i);
    }

    // 输入: s = "ABC"
    // 输出: 10
    // 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
    // 其中，每一个子串都由独特字符构成。
    // 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
    // 笨方法，列举出所有的子串然后一一计算每个子串中唯一字符个数，O(T)=O(n^2)会超时！
    public static int uniqueLetterString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String cur = s.substring(i, j);
                ans += getUniqueSubstringCnt(cur);
            }
        }
        return ans;
    }

    public static int getUniqueSubstringCnt(String s) {
        int[] cnt = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        for (int i : cnt) {
            if (i == 1) {
                res++;
            }
        }
        return res;
    }
}
