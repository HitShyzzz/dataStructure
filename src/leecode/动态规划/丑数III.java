package leecode.动态规划;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 从前往后依次遍历找第n个丑数，会超时！
 * @date: 2024-08-13 9:43
 */
public class 丑数III {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1000000000, 2, 168079517, 403313907));
    }

    // 输入：n = 5, a = 2, b = 11, c = 13
    // 输出：10
    // 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
    public static int nthUglyNumber(int n, int a, int b, int c) {
        long ans=0;
        int pa = 1;
        int pb = 1;
        int pc = 1;
        for (int i = 1; i <= n; i++) {
            ans = Math.min((long)pa * a, Math.min((long)pb * b, (long)pc * c));
            if (ans == (long) pa * a) {
                pa++;
            }
            if (ans == (long) pb * b) {
                pb++;
            }
            if (ans == (long) pc * c) {
                pc++;
            }
        }
        return (int)ans;
    }
}
