package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/12/9:38
 * @Description:
 */
public class 二进制求和 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    // 1010+1011=10101；
    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        StringBuilder sb = new StringBuilder();
        int len = Math.max(m, n);
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int n1 = (i < m ? a.charAt(m - 1 - i) - '0' : 0);
            int n2 = (i < n ? b.charAt(n - 1 - i) - '0' : 0);
            int sum = n1 + n2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
