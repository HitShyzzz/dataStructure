package leecode.Hot100;

import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-19 21:35
 */
public class 单词拆分方法2 {
    // 动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i]表示s的前i个字符能否被wordDict包含
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
