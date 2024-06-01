package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 10:13
 */
public class 给小朋友们分糖果I {
    public static void main(String[] args) {
        int n = 3;
        int limit = 3;
        int i = distributeCandies(n, limit);
        System.out.println(i);
    }

    //  输入：n = 5, limit = 2
    //  输出：3
    //  解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
    public static int distributeCandies(int n, int limit) {
        if (n > 3 * limit) {
            return 0;
        }
        int ans = 0;
        for (int x = 0; x <= limit; x++) {
            for (int y = 0; y <= limit; y++) {
                if (x + y > n) {
                    break;
                }
                int z = n - x - y;
                if (z <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
