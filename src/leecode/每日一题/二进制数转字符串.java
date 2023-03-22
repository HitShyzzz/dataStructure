package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/02/9:27
 * @Description:
 */
public class 二进制数转字符串 {
    // 0.625===》0.101
    // 实数*2相等于二进制小数点右移一位！
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (sb.length() <= 32 && num != 0) {
            num = num * 2;
            int digit = (int) num;
            sb.append(digit);
            num = num - digit;
        }
        return sb.length() > 32 ? "ERROR" : sb.toString();
    }
}
