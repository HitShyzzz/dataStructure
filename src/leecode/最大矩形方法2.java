package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/22/9:49
 * @Description:
 */
public class 最大矩形方法2 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];//left[i][j]表示matrix[i][j]左侧连续1的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new LinkedList<>();// 栈存的是行下标，同时保证从栈底到栈顶left[i][j]都是单调递增的
            int[] up = new int[m];// up[i]表示第i行上面left[i][j]的最小值
            int[] down = new int[m];// down[i]表示第i行下面left[i][j]的最小值
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
                int area = height * left[i][j];
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
