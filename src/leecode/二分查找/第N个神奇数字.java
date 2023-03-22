package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/22/12:14
 * @Description:
 */
public class 第N个神奇数字 {
    public static int mod = 1000000007;

    public static void main(String[] args) {
        int n = 4;
        int a = 2;
        int b = 3;
        int i = nthMagicalNumber(n, a, b);
        System.out.println(i);
    }

    public static int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = a * b / grad(a, b);// c是a,b的最小公倍数
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % mod);
    }

    // 找出a,b的最大公约数，辗转相除法
    public static int grad(int a, int b) {
        return b != 0 ? grad(b, a % b) : a;
    }
}
