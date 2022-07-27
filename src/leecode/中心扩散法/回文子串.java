package leecode.中心扩散法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/11:28
 * @Description:
 */
public class 回文子串 {
    public static void main(String[] args) {
        String s = "abc";
        int i = countSubstrings(s);
        System.out.println(i);
    }

    /**
     * 列举出所有的子串一一去判断每个子串是否是回文串
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (check(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @param s
     * @return s是否是回文串
     */
    public static boolean check(String s) {
        if (s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
