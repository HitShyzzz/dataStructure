package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/09/10:59
 * @Description:
 */
public class 最大加号标志 {
    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        int i = orderOfLargestPlusSign(n, mines);
        System.out.println(i);
    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            matrix[mines[i][0]][mines[i][1]] = 1;
        }
        int count = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                count = Math.max(count, find(matrix, n, i, j));
            }
        }
        return count;
    }

    public static int find(int[][] matrix, int n, int i, int j) {
        if (matrix[i][j] == 1) {
            return 0;
        }
        int k = 1;
        while (true) {
            // 一直向四个方向扩展
            if (i < k || matrix[i - k][j] == 1 || i + k == n || matrix[i + k][j] == 1 || j < k || matrix[i][j - k] == 1 || j + k == n || matrix[i][j + k] == 1) {
                break;
            }
            k++;
        }
        return k;
    }
}
