package leecode.二分查找;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/03/10:36
 * @Description:
 */
public class 寻找峰值方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 7, 8, 4};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    /**
     * 二分查找，当Nums[mid]>nums[mid+1]往右走是往下，不一定会有波峰，那就向左收缩，但如果nums[mid]<=nums[mid+1],往
     * 右走是往上，一定会有波峰，就向右收缩，最后左右指针相遇的位置就是波峰！
     * O(T)=O(logn);
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // 往右走是往下，不一定会有波峰，那就往左收缩
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {// 往右左是往上，一定会有波峰，那就往右走
                l = mid + 1;
            }
        }
        // 当左右指针相遇时，就是波峰
        return r;
    }
}
