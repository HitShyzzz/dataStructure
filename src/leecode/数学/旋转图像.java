package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/29/10:00
 * @Description:
 */
public class 旋转图像 {
    /**
     * 使用了辅助矩阵，虽然能过，但不符合题目要求
     * O(T)=O(n^2);
     * O(S)=O(n^2);
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }
}
