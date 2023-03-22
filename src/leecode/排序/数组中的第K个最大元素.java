package leecode.排序;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/11:32
 * @Description:
 */
public class 数组中的第K个最大元素 {
    /**
     * 先排序，再返回第k大元素就行了；
     * O(T)=O(nlogn),快速排序的时间复杂度是O(logn);
     * O(S)=O(logn);
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}
