package leecode.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/16:14
 * @Description:
 */
public class 每日温度方法2 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures1 = dailyTemperatures(temperatures);
        for (int t : temperatures1) {
            System.out.print(t + " ");
        }
    }

    /**
     * 单调栈，栈中存的是温度数组下标，满足从栈底到栈顶，温度递减！只有从栈底到栈顶的温度递减了，遇到温度比栈顶元素高的，
     * 才能去更新答案！
     * O(T)=O(n);每个元素只会进出一次栈！
     * O(S)=O(n);除了结果数组占用的额外空间，还需要O(n)的空间来存放栈中的元素！
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
