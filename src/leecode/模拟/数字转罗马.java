package leecode.模拟;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/30/16:12
 * @Description:
 */
public class 数字转罗马 {
    public static void main(String[] args) {
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
    }

    // 1994->"MCMXCIV"
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ans = "";
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            // 每次都贪心地去添加小于当前数的最大value
            while (num >= value) {
                ans += symbol;
                num -= value;
            }
            if (num == 0) {
                break;
            }
        }
        return ans;
    }
}
