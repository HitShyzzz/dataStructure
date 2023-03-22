package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/10:49
 * @Description:
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        String s="(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
    public static int longestValidParentheses(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int[]dp=new int[n];
        int ans=0;
        for(int i=1;i<n;i++){
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    dp[i]=(i-2>=0?dp[i-2]:0)+2;
                }else{
                    if (i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=dp[i-1]+2+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                    }
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}
