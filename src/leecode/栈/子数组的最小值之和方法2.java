package leecode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/28/13:46
 * @Description:
 */
public class 子数组的最小值之和方法2 {
    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        int i = sumSubarrayMins(arr);
        System.out.println(i);
    }

    // 3,1,2,4 ====>3 31 312 3124 1 12 124 2 24 4 3+1+1+1+1+1+1+2+2+4=17;
    private static final int mod = (int) Math.pow(10, 9) + 7;

    public static int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int n = arr.length;
        int[] left = new int[n];// left[i]表示arr[i]左侧以arr[i]为最小值的元素的数目
        int[] right = new int[n];// right[i]表示arr[i]右侧以arr[i]为最小值的元素的数目
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 栈为空说明arr[i]左侧元素都大于等于arr[i]，那么左侧以arr[i]为最小值的就有0到i个，共i+1个元素
            left[i] = stack.isEmpty() ? i + 1 : (i - stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // 栈为空，说明arr[i]右边的元素都大于arr[i],那么右侧以arr[i]为最小值的就有从i,i+1,...n-1个，总共是n-1-i+1=n-i个！
            right[i] = stack.isEmpty() ? n - i : (stack.peek() - i);
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % mod;
        }
        return (int) ans % mod;
    }
}
