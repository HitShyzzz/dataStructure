package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/20:46
 * @Description:
 */
public class 移动零方法3 {
    /**
     * 双指针，开始left和right都指向0，right指针指向非零元素，同时交换left和right指针，同时left指针右移，
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
