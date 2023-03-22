package leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/10/22:40
 * @Description:
 */
public class 每日温度方法2 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dailyTemperatures = dailyTemperatures(temperatures);
        for (int i : dailyTemperatures) {
            System.out.print(i + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int tempIndex = stack.pop();
                ans[tempIndex] = i - tempIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
