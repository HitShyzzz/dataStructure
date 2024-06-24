package leecode.每日一题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-24 22:35
 */
public class 下一个更大元素II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int[] ints = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));
    }

    // 输入: nums = [1,2,3,4,3]
    // 输出: [2,3,4,-1,4]
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 单调栈，栈存放的是数组元素下标，满足从栈底到栈顶的nums[i]依次递减
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int index = stack.pop();
                ans[index] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }
}
