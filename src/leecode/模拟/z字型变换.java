package leecode.模拟;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/15/20:37
 * @Description:
 */
public class z字型变换 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int l = (n / 2 == 0 ? 0 : 1) + (n / 2);
        int t = 2 * numRows - 2;// 周期t
        char[][] c = new char[numRows][l];
        String ans = "";
        int row = 0, col = 0;
        for (int i = 0; i < s.length(); i++) {
            c[row][col] = s.charAt(i);
            if (i % t < numRows - 1) {
                row++;
            } else {
                col++;
                row--;
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
                if (c[i][j] > 0) {
                    ans += c[i][j];
                }
            }
            System.out.println();
        }
        return ans;
    }
}
