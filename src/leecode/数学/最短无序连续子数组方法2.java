package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/22:16
 * @Description:
 */
public class 最短无序连续子数组方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    /**
     * 思路：我们可以把数组分成三段，A,B,C,我们只要把B排序整个数组都是有序的，现在需要找到B的左边界left和右边界right;
     * A是有序的，那么对于A中的元素必有nums[i]<=min(nums[j]),j=i+1,...n-1;那么最后一个让这个不等式不成立的i就是左边界left；
     * 同样的道理，C也是有序的，对于C中的元素，必有nums[i]>=max(nums[j]),j=0,...i-1那么最后一个让这个不等式成立的i就是
     * 右边界right；
     * 那么最短无序连续子数组的长度=right-left+1；
     * O(T)=O(n);一次遍历就能找到left和right；
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = n;
        for (int i = 0; i < n; i++) {
            // 更新right，应该从左往右走！
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                right = i;
            }
            // 更新left，应该从右往左走！
            if (min >= nums[n - 1 - i]) {
                min = nums[n - 1 - i];
            } else {
                left = n - 1 - i;
            }
        }
        return right == n ? 0 : right - left + 1;
    }
}
