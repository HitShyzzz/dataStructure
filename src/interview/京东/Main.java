package interview.京东;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/20:51
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        // 9999 8888
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        String s1 = s.substring(0, 4);
        // System.out.println(s1);
        String s2 = s.substring(5, s.length());
        // System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println(0);
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            } else if (c1 - c2 < 0) {
                res += (c1 - '0' + 9 - (c2-'0'));
            } else {
                res += (c1 - c2);
            }
        }
        System.out.println(res);
    }
}
