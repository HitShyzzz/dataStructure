package interview.中国移动;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/30/15:12
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        long m = Long.parseLong(str[0]);
        long n = Long.parseLong(str[1]);
        if (m > 0 && n > 0 && 3 * m < n && n < 4 * m) {
            long ans = (n - 3 * m) * (4 * m - n);
            System.out.println(ans);
        } else {
            System.out.println("坏盒子，你骗我！");
        }
    }
}
