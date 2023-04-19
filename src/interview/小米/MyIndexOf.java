package interview.小米;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/06/16:13
 * @Description:
 */
public class MyIndexOf {
    public static void main(String[] args) {
        String s = "abcdef";
        String p = "aaaaa";
        int i = myIndexOf(s, p);
        System.out.println(i);
    }

    public static int myIndexOf(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return -1;
        }
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        for (int i = 0; i + n < m + 1; i++) {
            int start = i;
            for (int j = 0; j < n; j++) {
                if (s1[start] == p1[j]) {
                    start++;
                } else {
                    break;
                }
            }
            if (start == i + n) {
                return i;
            }
        }
        return -1;
    }
}
