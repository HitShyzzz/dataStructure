package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/01/16:28
 * @Description:
 */
public class 两数相除 {
    public static void main(String[] args) {
        int dividend=Integer.MIN_VALUE-1;
        int divisor=-1;
        int divide = divide(dividend, divisor);
        System.out.println(divide);
    }
    public static int divide(int dividend, int divisor) {
        return Math.min((dividend / divisor), Integer.MAX_VALUE);
    }
}
