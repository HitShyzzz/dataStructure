package leecode.动态规划;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 二分查找
 * @date: 2024-08-13 9:43
 */
public class 丑数III方法2 {

    /**
     * @description: 对于数x，求[1,x]范围内丑数的个数，有7种情况：
     * 情况1：只被a整除的数字-------X/a-情况4-情况6-情况7
     * 情况2：只被b整除的数字-------X/b-情况4-情况5-情况7
     * 情况3：只被c整除的数字-------X/b-情况5-情况6-情况7
     * 情况4：同时被a，b整除的数字--------X/lab-情况7
     * 情况5：同时被b，c整除的数字--------X/lbc-情况7
     * 情况6：同时被a，c整除的数字--------X/lac-情况7
     * 情况7：同时被a,b,c整除的数字-------x/labc
     * 其中lab，lbc，labc分别表示ab，bc，abc的最小公倍数
     * 以上7种情况累加得到[1,X]范围内丑数的个数就是X/a+X/b+X/c-X/lab-X/lbc-X/lac+x/labc
     * 最后要找到[1,X]范围内丑数恰好为n个的数字X就是第n个丑数
     * 可以用二分查找来实现
     * @return:
     **/
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (a == 1 || b == 1 || c == 1)
            return n;
        int min = Math.min(a, Math.min(b, c));
        long left = min;
        long right = (long) Math.pow(min, n);
        long lab = lcm(a, b);
        long lac = lcm(a, c);
        long lbc = lcm(b, c);
        long labc = lcm(lab, c);
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = mid / a + mid / b + mid / c - mid / lab - mid / lbc - mid / lac + mid / labc;
            if (cnt == n) {
                left = mid;
                break;
            } else if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 如果找到的K∈[X,X+min(a,b,c)]，那么该范围内的任意K其实都有n个丑数，我们要找的是左边的X
        // X=K-min(K%a,K%b,K%c)
        return (int) (left - Math.min(left % a, Math.min(left % b, left % c)));
    }
    // 求a，b的最小公倍数
    public long lcm(long a, long b) {
        return a * b / grid(a, b);
    }

    // 求a，b的最大公约数
    public long grid(long a, long b) {
        if (a % b == 0)
            return b;
        return grid(b, a % b);
    }
}
