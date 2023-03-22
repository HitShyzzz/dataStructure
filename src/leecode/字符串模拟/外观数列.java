package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/11:21
 * @Description:
 */
public class 外观数列 {
    public static void main(String[] args) {
        int n = 5;
        String s = countAndSay(n);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String target = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int start = i;
            while (start < target.length() && target.charAt(start) == c) {
                start++;
            }
            sb.append(String.valueOf(start - i) + c);
            i = start - 1;
        }
        return sb.toString();
    }
}
