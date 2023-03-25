package interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/19:22
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            weights[i] = a * a;
        }
        for (int i : weights) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.sort(weights);
        while (m > 0) {
            long bag = in.nextLong();
            int i = 0;
            long cur = 0;
            long res = 0;
            while (cur <= bag && i < n) {
                cur += weights[i];
                if (cur <= bag) {
                    res++;
                }
                i++;
            }
            if (m > 1) {
                System.out.print(res + " ");
            } else {
                System.out.print(res);
            }
            m--;
        }
    }
}
