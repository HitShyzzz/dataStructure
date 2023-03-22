package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/23/7:47
 * @Description:
 */
public class 搜索旋转排序数组方法2 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int i = search(nums, 0);
        System.out.println(i);
    }

    /**
     * 我们将数组一分为二，一定有一部分是有序的，只要在有序部分进行二分查找，
     * 继续这样做下去，直到找到target为止！
     * O(T)=O(logn);// 二分查找的时间复杂度就是对数阶的！
     * O(S)=O(1);
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 这意味着nums[0,mid]是有序的，在[0,mid]进行二分查找
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {// target不在这个区间，虽然这个区间有序也没用！
                    l = mid + 1;
                }
            }
            // 这意味着nums[mid,n-1]是有序的，在[mid,n-1]进行二分查找
            else if (nums[mid] <= nums[n - 1]) {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
