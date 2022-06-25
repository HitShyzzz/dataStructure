package leecode.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/24/11:45
 * @Description:
 */
public class 接雨水方法3 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 单调栈！维护一个栈，栈中放的是数组元素的下标，满足从栈底到栈顶高度是递减的，因为只有高度递减，再遇到一个高度比
     * 栈顶高度高的才能接到雨水啊，
     * O(T)=O(n)，一遍扫描即可；
     * O(S)=O(n),最坏情况下数组递减则需要O(n)的空间复杂度!
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();// 出去的这个柱子就是要接住雨水的柱子，因为它的两边都比他要高啊
                if (stack.isEmpty()) {// pop之后栈就空了，也就是左边没柱子了，当然接不了水了；
                    break;
                }
                int width = i - stack.peek() - 1;// 接到雨水的宽度
                // 还是每个柱子能接的雨水是左右两边高度的较小者-当前柱子的高度；
                int true_height = Math.min(height[stack.peek()], height[i]) - height[top];
                ans += true_height * width;
            }
            stack.push(i);
        }
        return ans;
    }
}
