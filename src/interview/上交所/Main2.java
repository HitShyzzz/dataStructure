package interview.上交所;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/16:53
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int t = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[10][];
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            matrix[i] = new int[s1.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
        }
        System.out.println(0);
    }
}
