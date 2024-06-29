package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-29 0:02
 */
public class 移除字符串中的尾随零 {
    public static void main(String[] args) {
        String s = removeTrailingZeros("51230100");
        System.out.println(s);
    }

    // 输入：num = "51230100"
    // 输出："512301"
    // 解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
    public static String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }
}
