package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/23/7:45
 * @Description:
 */
public class 搜索旋转排序数组 {
    /**
     * 最直接的想法一遍扫描，
     * 但这样就没利用上数组部分有序这个条件
     * O(T)=O(n);
     * O(S)=O(1);
     * 不符合题目要求的时间复杂度O(logn);
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
