package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: O(T)=O(nlogv)，n是数组的长度，v是元素的取值范围
 * @date: 2024-07-30 20:46
 */
public class 双模幂运算 {
    public static void main(String[] args) {
        int[][] variables = {{31, 12, 21, 24}};
        System.out.println(pow(3, 10));
        List<Integer> goodIndices = getGoodIndices(variables, 1);
        System.out.println(goodIndices);
    }

    // 输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
    // 输出：[0,2]
    // 解释：对于 variables 数组中的每个下标 i ：
    // 1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(23 % 10)3 % 10 = 2 。
    // 2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(33 % 10)3 % 1 = 0 。
    // 3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(61 % 10)1 % 4 = 2 。
    // 因此，返回 [0,2] 作为答案。
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int d = variables[i][3];
            if (powMod(powMod(a, b, 10), c, d) == target) list.add(i);
        }
        return list;
    }

    /**
     * @description: 快速幂的思想，其实就是分治思想
     * @return: 求x的y次幂%mod的结果
     **/
    public static int powMod(int x, int y, int mod) {
        int res = 1;
        while (y != 0) {
            // y是奇数，此时要多乘一个x
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            // 偶数的话，y=x^2
            x = x * x % mod;
            // y不断的除以2
            y = y >> 1;
        }
        return res;
    }

    /**
     * @description:
     * @return: 求x的y次幂
     **/
    public static int pow(int x, int y) {
        int res = 1;
        while (y != 0) {
            // y是奇数，此时要多乘一个x
            if ((y & 1) != 0) {
                res = res * x;
            }
            // 偶数的话，y=x^2
            x = x * x;
            // y不断的除以2
            y = y >> 1;
        }
        return res;
    }
}
