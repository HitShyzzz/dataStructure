package interview.用友;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/15:32
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur != 0) {
                if (cur % 10 == 2) {
                    res++;
                }
                cur = cur / 10;
            }
        }
        System.out.println(res);
    }
}
