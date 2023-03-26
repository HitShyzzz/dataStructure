package interview.上交所;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/16:18
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = 0;
        // 处理本来就相等的情形
        boolean flag = true;
        while (true) {
            int num = n;
            int low = 0;
            int high = 0;
            for (int i = 1; i <= 6; i++) {
                if (i <= 3) {
                    low += (num % 10);
                    num = num / 10;
                } else {
                    high += (num % 10);
                    num = num / 10;
                }
            }
            if ((!flag) && (low == high)) {
                break;
            } else {
                flag = false;
                n++;
            }
        }
        System.out.println(n);
    }
}
