package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 暴力计算，直接超时！
 * @date: 2024-08-05 9:24
 */
public class 不含连续1的非负整数 {
    public static void main(String[] args) {
        int integers = findIntegers(5);
        System.out.println(integers);
    }

    public static int findIntegers(int n) {
        int res = n + 1;
        for (int i = 2; i <= n; i++) {
            // 按位与操作的结果不为0，则必然存在连续的1
            // 但还是超时
            if ((i & (i << 1)) != 0) {
                res--;
            }
        }
        return res;
    }
}
