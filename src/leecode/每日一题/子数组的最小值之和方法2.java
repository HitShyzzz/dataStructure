package leecode.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/28/13:09
 * @Description:
 */
public class 子数组的最小值之和方法2 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int i = sumSubarrayMins(arr);
        System.out.println(i);
    }

    // 3,1,2,4 ====>3 31 312 3124 1 12 124 2 24 4 3+1+1+1+1+1+1+2+2+4=17;
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        // left[i]表示以arr[i]最左且最小的下标
        int[] left = new int[n];
        // right[i]表示以arr[i]最右且最小的下标
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > cur) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= cur) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            res = res + ((long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }
        return (int) (res % MOD);
    }
}
