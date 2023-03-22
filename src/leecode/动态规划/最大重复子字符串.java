package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/03/12:10
 * @Description:
 */
public class 最大重复子字符串 {
    public static void main(String[] args) {
        String sequence = "ababc";
        String word = "ab";
        int i = maxRepeating(sequence, word);
        System.out.println(i);
    }

    // sequence=ababc word=ab===>2;
    public static int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int ans = 0;
        if (m > n) {
            return 0;
        }
        int[] dp = new int[n];//dp[i]表示的是word在第i个位置的最大重复数
        for (int i = m - 1; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                if (sequence.charAt(i - m + 1 + j) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                dp[i] = i >= m ? dp[i - m] + 1 : 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
