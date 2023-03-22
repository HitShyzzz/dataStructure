package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/22/19:46
 * @Description:
 */
public class 最长有效括号方法2 {
    public static void main(String[] args) {
        String s = "(()())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

    /**
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // dp[i]表示以下标i结尾的最长有效子串长度，我们需要返回所有dp[i]的最大值！
        // 动态规划的题目定义好dp[i]才是最关键的；
        int[] dp = new int[n];
        char[] c = s.toCharArray();
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            // 所有有效的子串必定以‘）’结尾，因此所有c[i]=='('的dp[i]必然都是0；
            if (c[i] == ')') {
                if (c[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {// 这里是最关键的，c[i]=')',c[i-1]=')',那么我们需要找到以c[i-1]结尾的有效的子串开始的下标
                    // 是i-dp[i-1],如果c[i-1]最长有效子串前面的位置即i-dp[i-1]-1刚好是'(',那么c[i]就刚好能有效，
                    // 此时dp[i]=c[i-1]的有效字段+2+c[i-1]有效字段前面的有效字段长度，即
                    // dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2];如果i-dp[i-1]-1的位置是‘）’那么此时这个c[i]肯定是没人搭配的
                    // 这种情况下dp[i]必然是0！
                    if (i - dp[i - 1] - 1 >= 0 && c[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        return maxLen;
    }
}
