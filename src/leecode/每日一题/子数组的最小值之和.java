package leecode.每日一题;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/28/13:09
 * @Description:
 */
public class 子数组的最小值之和 {
    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        int i = sumSubarrayMins(arr);
        System.out.println(i);
    }

    private static double ans = 0;

    // 3,1,2,4 ====>3 31 312 3124 1 12 124 2 24 4 3+1+1+1+1+1+1+2+2+4=17;
    public static int sumSubarrayMins(int[] arr) {
        dfs(arr, 0);
        return (int)(ans%(Math.pow(10,9)+7));
    }
    // 能做但会超时！
    public static void dfs(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = index; i < arr.length; i++) {
            pq.offer(arr[i]);
            ans += pq.peek();
        }
        dfs(arr, index + 1);
    }
}
