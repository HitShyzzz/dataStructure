package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-28 20:42
 */
public class 每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {30, 40, 50, 60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    //  输入: temperatures = [73,74,75,71,69,72,76,73]
    //  输出: [1,1,4,2,1,1,0,0]
    // 单调栈，从栈底到栈顶，温度依次降低
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
