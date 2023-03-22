package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/23/9:20
 * @Description:
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8};
        int target = 8;
        int[] searchRange = searchRange(nums, target);
        for(int i:searchRange){
            System.out.print(i+" ");
        }
    }

    /**
     * 我们要找的是start就是nums数组中第一个大于等于target的下标，而end就是nums数组中第一个大于target的下标，然后再减去1；
     *O(T)=O(logn);
     * O(S)=O(1);
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start=BinarySearch(nums,target,true);
        int end=BinarySearch(nums,target,false);
        return new int[]{start, end};
    }

    /**
     * 查找nums数组中==target开始的下标 start和结束的下标end；
     * 当flag为true时是找start，为false时是找end;
     * 对照一个例子把这个例子搞通，能通过一大半用例！
     *
     * @param nums
     * @param target
     * @param flag
     * @return
     */
    public static int BinarySearch(int[] nums, int target, boolean flag) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int index = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                index = mid;
            }
            if ((!flag && nums[mid] <= target) || nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}
