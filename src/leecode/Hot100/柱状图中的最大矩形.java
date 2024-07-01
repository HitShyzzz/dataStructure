package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: O(T)=O(N),O(S)=O(N)，单调栈
 * @date: 2024-07-01 21:48
 */
public class 柱状图中的最大矩形 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }

    // 输入：heights = [2,1,5,6,2,3]
    // 输出：10
    // 解释：最大的矩形为图中红色区域，面积为 10
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // left[i]表示i左侧第一个比height[i]矮的下标
        int[] left = new int[n];
        // right[i]表示i右侧第一个比height[i]矮的下标
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
