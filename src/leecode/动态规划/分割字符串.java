package leecode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/16/21:20
 * @Description:
 */
public class 分割字符串 {

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    boolean[][] dp;
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        // dp[i][j]表示s[i，j]是否是回文串！
        dp = new boolean[n][n];
        // 先把所有的dp[i][j]都设置为true，再把上对角元素该是false的设置为false！
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return res;
    }

    /**
     * @param s
     * @param i
     * @Author Shy
     * @Description if s[i,j]是回文串，就把s[i,j]添加到结果集，并把j+1作为下次递归的起始边界
     * @Date 2023/8/16 21:23
     **/
    public void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
