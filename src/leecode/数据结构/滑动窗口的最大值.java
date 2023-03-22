package leecode.数据结构;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/8:18
 * @Description:
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 最直接的想法，在每个窗口内直接求最大值，这样每个窗口内需要O(k)的时间来遍历每个元素，总共有n-k+1个窗口
     * ，总的时间复杂度会达到O(k(n-k+1))=O(nk),会超时！
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}
