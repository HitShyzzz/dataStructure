package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-28 10:58
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        String s = "()(())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

    // 输入：s = ")()())"
    // 输出：4
    // 解释：最长有效括号子串是 "()()"
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        // dp[i]表示以s[i]结尾的最长有效括号长度
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {// 只有是右括号才有必要去更新dp[i]
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {// s[i-1]=')'，那么和s[i-1]配套的左括号下标就是i-dp[i-1]，则和i对应的匹配下标就是i-dp[i-1]-1
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}
