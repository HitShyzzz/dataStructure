package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/31/10:38
 * @Description:
 */
public class 字符串转换整数 {
    public static void main(String[] args) {
        String s = ".2";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int start = 0;// 记录第一个非空格字符
        int sign = 1;// 符号
        int ans = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        start = i;
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (i == start && c == '+') {
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
                // 判断是数字
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                // 整数超界限的情况
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                } else if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + sign * num;
            } else {// 遇到其他的情况直接退出循环，如"",字母等！
                break;
            }
        }
        return ans;
    }
}