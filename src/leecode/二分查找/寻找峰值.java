package leecode.二分查找;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/03/10:17
 * @Description:
 */
public class 寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    /**
     * 单调栈，栈中存放数组的下标，满足从栈底到栈顶元素递增，如果遇到一个比当前元素小的，那么栈顶元素就是答案！
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                return stack.peek();
            }
        }
        // 当数组递增时，就直接返回栈顶元素，也就是n-1；
        return stack.peek();
    }
}
