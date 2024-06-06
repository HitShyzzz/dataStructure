package interview.衍复;

import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-06 22:40
 */
public class Main3 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        int i = maxSumSubmatrix(matrix, k);
        System.out.println(i);
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        // pre[i][j] 表示以matrix[i][j]为右下角的矩阵的所有元素之和
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        // 考虑以[i,j]为矩阵左上角，[s,t]为矩阵右下角形成的矩阵的元素和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int s = i; s <= m; s++) {
                    for (int t = j; t <= n; t++) {
                        int cur = pre[s][t] - pre[i - 1][t] - pre[s][j - 1] + pre[i - 1][j - 1];
                        if (cur <= k) {
                            ans = Math.max(ans, cur);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
