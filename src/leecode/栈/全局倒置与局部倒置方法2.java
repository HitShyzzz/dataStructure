package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/16/9:34
 * @Description:
 */
public class 全局倒置与局部倒置方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        boolean idealPermutation = isIdealPermutation(nums);
        System.out.println(idealPermutation);
    }

    public static boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 2; i < n; i++) {
            if (nums[i] < max) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
