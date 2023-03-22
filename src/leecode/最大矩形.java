package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/12/15:15
 * @Description:
 */
public class 最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }};
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];// left[i][j]表示在matrix[i][j]左侧连续1的数量
        // 给left矩阵赋值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];// 矩形的宽是width=Math.min(width,left[kl[j])
                int area = width;// 矩形的面积
                for (int k = i - 1; k >= 0; k--) {
                    if(left[k][j]==0){
                        break;
                    }
                    width = Math.min(width, left[k][j]);
                    area = Math.max(width * (i - k + 1), area);
                }
                res = Math.max(area, res);
            }
        }
        return res;
    }
}
