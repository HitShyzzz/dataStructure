package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 8:06
 */
public class 构造颜色相同的正方形 {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == grid[i + 1][j] && grid[i][j] == grid[i][j + 1]) {
                    return true;
                }
                if (grid[i + 1][j] == grid[i][j + 1] && grid[i + 1][j] == grid[i + 1][j + 1]) {
                    return true;
                }
                if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 1][j + 1]) {
                    return true;
                }
                if (grid[i][j] == grid[i][j + 1] && grid[i][j + 1] == grid[i + 1][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
