package interview.中兴;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/25/15:22
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int numRows = in.nextInt();
        String s1 = printString(s, numRows);
        System.out.println(s1);

    }

    public static String printString(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        int t = 2 * (numRows - 1);// 周期T
        int c = (n % t == 0 ? n / t : n / t + 1) * (numRows - 1);// 矩阵的列数
        char[][] matrix = new char[numRows][c];
        int x = 0;// 矩阵的横坐标
        int y = 0;// 矩阵的纵坐标
        for (int i = 0; i < s.length(); i++) {
            matrix[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] rows : matrix) {
            for (char ch : rows) {
                if (ch != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
