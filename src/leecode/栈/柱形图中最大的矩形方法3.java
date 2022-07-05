package leecode.栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/21:34
 * @Description:
 */
public class 柱形图中最大的矩形方法3 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }

    /**
     * 单调栈，栈里存放的是数组下标，满足自栈底到栈顶高度是递增的，这里高度是递增是因为只有高度增加了，面积才能更大啊。
     * 而接雨水那道题高度要递减是因为只有高度下降了，才能接到更多的雨水啊
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(r, n);
        int area = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                r[stack.peek()] = i;
                stack.pop();
            }
            l[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(l[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.print(r[i] + " ");
//        }
        for (int i = 0; i < n; i++) {
            area = Math.max(area, (r[i] - l[i] - 1) * heights[i]);
        }
        return area;
    }
}
