package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 常规写法，O(m^2*n)，好理解一点
 * @date: 2024-07-01 20:14
 */
public class 最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = maximalRectangle(matrix);
        System.out.println(i);
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // left[i][j]表示的是matrix[i][j]左侧（包含matrix[i][j]）的连续1的数量
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            left[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int k = i;
                    int height = 1;
                    int width = left[i][j];
                    int area = width;
                    while (k > 0 && matrix[k][j] == '1') {
                        k--;
                        // 矩形的宽==所有该列left[i][j]的最小值，
                        // 其实就是放倒的柱状图
                        width = Math.min(width, left[k][j]);
                        height++;
                        area = Math.max(area, width * height);
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
}
