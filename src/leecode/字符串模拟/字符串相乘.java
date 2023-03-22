package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/05/10:45
 * @Description:
 */
public class 字符串相乘 {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        String s = multiply(num1, num2);
        System.out.println(s);
    }

    /**
     * 像做乘法竖式一样，一位一位计算！
     * 125
     * 12    --------->  125   +  125
     * 2        1
     * ______________
     * 250+   1250=1500
     * ————
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "";
        int m = num1.length();
        int n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int change = 0;// 进位
            // 计算过1位之后后面都要补上0
            for (int j = n - 1; j > i; j--) {
                sb.append("0");
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + change;
                sb.append(product % 10);
                change = product / 10;
            }
            if (change != 0) {
                sb.append(change);
            }
            ans = addStrings(ans, sb.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        if (num1.equals("")) {
            return num2;
        }
        if (num2.equals("")) {
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int change = 0;// 进位
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || change != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + change;
            sb.append(sum % 10);
            change = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }


}
