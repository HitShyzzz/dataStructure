package leecode.recur;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/17:38
 * @Description:
 */
public class 单词拆分方法3 {
    /**
     * 动态规划，设dp[i]表示s[0,i)能否由wordDict拼接成，我们需要返回dp[n];
     * 那么dp[i]=true if dp[j]=true且wordDict包含了s.substring(j,i);
     * O(T)=O(n^2);总共有n个状态，每个状态还要去列举能到达i的情况，
     * O(S)=O(n);动态规划需要O(n)来存储动态数组！
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;//此时s是空串，定义为true!
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
