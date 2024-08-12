package leecode.动态规划;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-12 21:14
 */
public class 丑数 {
    public static void main(String[] args) {
        boolean ugly = isUgly(-1000);
        System.out.println(ugly);
    }

    public static boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
