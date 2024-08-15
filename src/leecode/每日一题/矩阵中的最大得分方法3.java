package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 在方法2基础上，进一步优化空间复杂度为
 * O(S)=O(m)
 * @date: 2024-08-15 9:46
 */
public class 矩阵中的最大得分方法3 {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>(List.of(List.of(9, 5, 7, 3), List.of(8, 9, 6, 1), List.of(6, 7, 14, 3), List.of(2, 5, 3, 1)));
        int i = maxScore(grid);
        System.out.println(i);
    }

    // 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
    //
    // 输出：9
    public static int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int ans = Integer.MIN_VALUE;
        // preCol[i][j]的计算只与pre[i-1][j]有关，因此用一维数组preCol[j]代替pre[i-1][j]
        int[] preCol = new int[n];
        Arrays.fill(preCol, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            // preRow[i][j]的计算只与preRow[i][j-1]有关，因此可以用常数变量preRow代替preRow[i][j]
            int preRow = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int dp = Integer.MIN_VALUE;
                if (j > 0) {
                    dp = Math.max(dp, grid.get(i).get(j) + preRow);
                }
                if (i > 0) {
                    dp = Math.max(dp, grid.get(i).get(j) + preCol[j]);
                }
                ans = Math.max(dp, ans);
                preRow = Math.max(preRow, Math.max(dp, 0) - grid.get(i).get(j));
                preCol[j] = Math.max(preCol[j], Math.max(dp, 0) - grid.get(i).get(j));
            }
        }
        return ans;
    }
}
