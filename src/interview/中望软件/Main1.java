package interview.中望软件;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/20:19
 * @Description:
 */
public class Main1 {
    public int diagonalSum(int[][] mat) {
        // write code here
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        if (n % 2 != 0) {
            sum -= mat[(n - 1) / 2][(n - 1) / 2];
        }
        return sum;
    }
}
