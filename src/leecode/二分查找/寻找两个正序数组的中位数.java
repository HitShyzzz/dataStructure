package leecode.二分查找;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/02/18:48
 * @Description:
 */
public class 寻找两个正序数组的中位数 {
    /**
     * 最直接的想法，把两个数组合并，然后排序；如果合并后的数组长度n是奇数，那么中位数就是num[n/2];如果是偶数
     * 中位数是nums[n/2-1]和nums[n/2]的平均数；
     * 也可以把奇偶统一起来，就是num[(n+1)/2-1]和num[(n+2)/2-1]的平均数;
     * O(T)=O((m+n));// 数组复制为O(m+n),排序为O(m+n),合起来是O(m+n);
     * O(S)=O((m+n));需要新的空间来存放合并后的数组！
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num, 0, nums1.length);
        System.arraycopy(nums2, 0, num, nums1.length, nums2.length);
        Arrays.sort(num);
        int n = num.length;
        // if (n % 2 != 0) {
        //     return num[n / 2] * 1.0;
        // } else {
        //     return (num[n / 2] + num[n / 2 - 1]) / 2.0;
        // }
        return (num[(n + 1) / 2 - 1] + num[(n + 2) / 2 - 1]) / 2.0;
    }
}
