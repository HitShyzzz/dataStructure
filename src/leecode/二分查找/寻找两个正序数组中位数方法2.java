package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/02/18:48
 * @Description:
 */
public class 寻找两个正序数组中位数方法2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    /**
     * 二分查找！
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int left = (n + 1) / 2;
        int right = (n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 中位数就是第（m+n+1）/2小的元素和第（m+n+2）小的元素的平均数，
     * 这个方法就是来查找第k小的元素，考虑二分查找！
     * O(T)=O(log(m+n)).二分查找的时间复杂度就是O(log(m+n)).
     * O(S)=O(log(m+n).递归栈空间的调用，找第k大元素最多调用log(m+n)次？
     *
     * @param nums1
     * @param i     nums1数组的起始地址
     * @param nums2
     * @param j     nums2数组的起始地址
     * @param k     要找的第小大元素
     * @return 第k小元素
     */
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 数组1起始地址超过了数组1的长度，那么只能在数组2中找了；
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        // 数组2起始地址超过了数组2的长度，那么只能在数组1中找了；
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        // 第1小的元素就是两个数组起始地址元素的较小者了；
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // 这里把i+k/2-1>=nums1.length的情况中间值设为最大数，是说说明此时数组1的长度是小于k/2的那么
        // 这第k小的元素在不在数组1我们不知道，但是数组2的前k/2个元素一定是不能要的；
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        // 此时第k小的元素一定不在数组1的前k个，因此要把数组1的起始搜索地址加上k/2,同时目标k减去k/2;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
