package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/10:11
 * @Description:
 */
public class 无重复最长子串方法2 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }
        int dp = 0;// dp[i]表示以s[i]结尾的最长无重复子串开始的下标
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();// 用来存储s[i]在[dp[i-1],i-1]出现的最后下标
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer repeatIndex = map.get(c);
            if (repeatIndex != null && repeatIndex >= dp) {// s[i]在[dp[i-1],i-1]出现了，那么dp[i]=repeatIndex+1;如果s[i]未在[0,i-1]出现或者在[0,dp[i-1]]出现，那么dp[i]=dp[i-1];
                dp = repeatIndex + 1;
            }
            ans = Math.max(ans, i - dp + 1);
            map.put(c, i);
        }
        return ans;
    }
}
