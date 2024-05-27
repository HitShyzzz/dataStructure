package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-27 20:23
 */
public class 找出缺失的观测数据方法2 {
    public static void main(String[] args) {
        int[] rolls = {4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5};
        int mean = 4;
        int n = 40;
        int[] ints = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int target = mean * (m + n) - sum;
        if (target < n || target > 6 * n) {
            return new int[]{};
        }
        int[] res = new int[n];
        int ave = target / n;
        int rd = target % n;
        // target=ave*n+target%n==rd*(ave+1)+(n-rd)*ave
        // 余数个ave+1,n-rd个ave
        Arrays.fill(res, 0, rd, ave + 1);
        Arrays.fill(res, rd, n, ave);
        return res;
    }
}
