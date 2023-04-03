package interview.京东;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/23:09
 * @Description:
 */
public class Main31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] counts = new int[4];
        // 先去计算每个字符个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'r') {
                counts[0]++;
            } else if (c == 'e') {
                counts[1]++;
            } else if (c == 'd') {
                counts[2]++;
            } else {
                counts[3]++;
            }
        }
        long res = 0;
        // max是r e d 中最大的数
        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));

        // 至少需要的?个数
        int needCount = 3 * max - (counts[0] + counts[1] + counts[2]);
       // System.out.println(needCount);
        if (counts[3] < needCount) {
            System.out.println(0);
        } else if (counts[3] == needCount) {
            int a = max - counts[0];// 需要的r个数
            int b = max - counts[1];// 需要的e个数
            int c = max - counts[2];// 需要的d个数
            res = jieCheng(needCount) / (jieCheng(a) * jieCheng(b) * jieCheng(c));
            System.out.println(res);
        } else {// ?多于需要的
            int group = (counts[3] - needCount) / 3;
            for (int i = 1; i <= group; i++) {
                int remain = counts[3] - needCount - i * 3;
                res = res + (jieCheng(counts[3] - needCount) / (jieCheng(i) * jieCheng(i) * jieCheng(i) * jieCheng(remain)));
            }
            res = res + 1;// 不用?
            System.out.println(res);
        }
    }
    // 计算排列数

    /**
     * @param n
     * @param k
     * @return A(n, k)的值
     */
    public static long function(int n, int k) {
        return jieCheng(n) / jieCheng(n - k);
    }

    // 计算阶乘
    public static long jieCheng(int n) {
        // 0的阶乘是1
        if (n == 0) {
            return 1;
        }
        long prod = 1;
        for (int i = 1; i <= n; i++) {
            prod = prod * i;
        }
        return prod;
    }

}
