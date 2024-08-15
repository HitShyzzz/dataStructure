package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 二维前缀和
 * 设移动的路径的数值分别是x0,x1,...,xt，那么得分就是(x1-x0)+(x2-x1)+,...+(xt-xt-1)=xt-x0，只与起点终点有关！
 * 那么dp[i][j]=max(grid[i][j]-grid[x][y])，其中x∈[0,i]，y∈[0,j],(x,y)≠(i,j)
 * 进一步有dp[i][j]=grid[i][j]-min(grid[x][y])，其中x∈[0,i]，y∈[0,j],(x,y)≠(i,j)
 * O(S)=O(mn)
 * @date: 2024-08-15 9:46
 */
public class 矩阵中的最大得分方法4 {
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
        int[][] preMin = new int[m][n];
        for (int[] p : preMin) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int pre = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    pre = Math.min(pre, preMin[i][j - 1]);
                }
                if (i > 0) {
                    pre = Math.min(pre, preMin[i - 1][j]);
                }
                if (i + j > 0) {
                    ans = Math.max(ans, grid.get(i).get(j) - pre);
                }
                preMin[i][j] = Math.min(pre, grid.get(i).get(j));
            }
        }
        return ans;
    }
}
