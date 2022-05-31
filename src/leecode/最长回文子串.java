package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/09/12:59
 * @Description:
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for (int center = 0; center < 2 * len - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String temp = s.substring(left, right + 1);
                if (temp.length() > res.length()) {
                    res = temp;
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
