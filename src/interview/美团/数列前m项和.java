package interview.美团;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/16:47
 * @Description:
 */
public class 数列前m项和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            double sum = 0d;
            for (int i = 0; i < m; i++) {
                double am = n;
                for (int j = 0; j < i; j++) {
                    am = Math.sqrt(am);
                }
                sum += am;
            }
            System.out.printf("%.2f", sum);
        }
    }
}
