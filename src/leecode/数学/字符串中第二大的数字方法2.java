package leecode.数学;

import java.util.Locale;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/03/10:20
 * @Description:
 */
public class 字符串中第二大的数字方法2 {
    public static void main(String[] args) {
        String s = "abc1111";
        int i = secondHighest(s);
        System.out.println(i);
    }

    // dfa12321afd
    public static int secondHighest(String s) {
        int first = -1; // 第一大数字
        int second = -1;// 第二大数字
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;// 这里必须先去修改second，否则second就变成修改之后的新的first了！
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }
}
