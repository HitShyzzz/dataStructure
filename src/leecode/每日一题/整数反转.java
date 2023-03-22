package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/27/19:06
 * @Description:
 */
public class 整数反转 {
    public static void main(String[] args) {
        int x = -2147483648;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            int a = rev(-x);
            return -a;
        } else {
            return rev(x);
        }
    }

    /**
     * @param x x>0
     * @return 正数x反转的结果
     */
    public static int rev(int x) {
        long ans = 0;
        while (x != 0) {
            int temp = x % 10;
            ans = ans * 10 + temp;
            x = x / 10;
        }
        return ans >= Integer.MAX_VALUE ? 0 : (int) ans;
    }
}
