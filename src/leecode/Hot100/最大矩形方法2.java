package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 单调栈，O(T)=O(M*N)，O(S)=O(M*N)
 * @date: 2024-07-01 20:14
 */
public class 最大矩形方法2 {
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
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        // 对每一列使用柱状图的做法：单调栈，满足从栈底倒栈顶left[i][j]依次递增，那么突然遇到个小的，就是矩形的
        // 宽（短板效应）
        for (int j = 0; j < n; j++) {
            // up[i]表示的是从i向上走第一个比left[i][j]小的横坐标
            int[] up = new int[m];
            // down[i]表示的是从i向下走第一个比left[i][j]小的横坐标
            int[] down = new int[m];
            Deque<Integer> stack = new ArrayDeque<>();
            // 栈中满足从上到下,left[k][j]依次严格递增，这样遇到一个小的，就是要算的up[i]
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                ans = Math.max(ans, height * left[i][j]);
            }
        }
        return ans;
    }
}
