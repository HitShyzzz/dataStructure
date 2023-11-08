package leecode.每日一题;

import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/08/22:09
 * @Description:
 */
public class 最长平衡子字符串 {
    public static void main(String[] args) {
        String s = "0111";
        int theLongestBalancedSubstring = findTheLongestBalancedSubstring(s);
        System.out.println(theLongestBalancedSubstring);
    }

    // 输入：s = "01000111"
    // 输出：6
    // 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
    public static int findTheLongestBalancedSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == '0') {
                j++;
            }
            if (j == s.length()) {
                break;
            }
            int lenOf0 = j - i;
            int k = j;
            while (k < s.length() && s.charAt(k) == '1') {
                k++;
            }
            int lenOf1 = k - j;
            // 连续0个数和连续1个数较小者*2就是当前平衡子字符串的长度
            int len = Math.min(lenOf1, lenOf0) * 2;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
