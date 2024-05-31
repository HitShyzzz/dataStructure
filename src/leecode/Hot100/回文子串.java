package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-31 21:16
 */
public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    // 中心扩散法
    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + (i % 2);
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
