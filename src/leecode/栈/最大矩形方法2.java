package leecode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/23:43
 * @Description:
 */
public class 最大矩形方法2 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        // char[][] matrix = {{'0', '1'}, {'1', '0'}};
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }

    /**
     * 模仿上道题的思路，对矩阵的每一列都去利用单调栈，找到每个位置的上下边界，则
     * area=(down[i]-up[i]-1)*left[i][j],动态更新area取最大值就行；
     * 这里left[i][j]表示matrix[i][j]左侧连续1的数量，（保活matrix[i][j]本身）
     * up[i]表示matrix[i][j]上面行第一个小于left[i][j]的行坐标；
     * down[i]表示matrix[i][j]下面行第一个小于left[i][j]的行坐标！
     * 单调栈中存的是行坐标，满足从栈底到栈顶left[i][j]值严格递增！
     * O(T)=O(mn);首先需要O(mn)计算left矩阵，然后每一列单调栈计算需要O(m)的时间，总共有n列，就是O(mn)的时间！
     * O(S)=O(mn);需要O(mn)的2=空间复杂度来存储left矩阵！
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 先去维护left[i][j]矩阵
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 1 : left[i][j - 1] + 1);
                }
            }
        }
        int[] up = new int[m];// 类似于柱形图的左边界
        int[] down = new int[m];// 类似于柱形图的右边界
        int area = 0;
        // 对矩阵的每一列都利用单调栈的思路计算面积，柱子的高是left[i][j]
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                // 必须维护栈中left[i][j]是严格递增的，这里是小于等于！
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                // 必须维护栈中left[i][j]是严格递增的，这里是小于等于！
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                if (left[i][j] == 0) {
                    continue;
                }
                area = Math.max(area, (down[i] - up[i] - 1) * left[i][j]);
            }
        }
        return area;
    }
}

