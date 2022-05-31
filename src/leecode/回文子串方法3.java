package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/09/12:40
 * @Description:
 */
public class 回文子串方法3 {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        // 中心扩散法共有2*len-1个中心，以单个字符为中心有len个，以两个字符为中心的有len-1个，
        for (int center = 0; center < 2 * len - 1; center++) {
            // 左边扩展的坐标
            int left = center / 2;
            // 右边扩展时有两种情况，1.center是偶数时left和right指向同一个字符，2.center是奇数时，right指向left后一位。
            int right = left + center % 2;
            // s[left]==s[right]就能向两侧扩展
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
