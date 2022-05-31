package leecode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/19/14:07
 * @Description:
 */
public class 柱形图中最大的矩形方法2 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int rectangleArea = largestRectangleArea(heights);
        System.out.println(rectangleArea);
    }

    /**
     * 单调栈解法
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];// 存放第i根柱子左侧高度小于height[i]且最近柱子的下标；
        int[] right = new int[n];// 存放第i根柱子右侧高度小于height[i]且最近柱子的下标；
        Deque<Integer> stack = new ArrayDeque<>();// 单调栈存的是小于height[i]且最近柱子的下标，保证从栈底到栈顶柱子的高度递增；
        // 如果栈为空了，说明没有比当前柱子高度更低的，此时下标记为-1；
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
