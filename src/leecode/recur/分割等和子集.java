package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/20:37
 * @Description:
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return recur(nums, 0, target);

    }

    /**
     * 递归的去添加，每个结点都有两种情况，添加或者不添加，这样写时间复杂度是比较高的，这道题会超时！
     *
     * @param nums
     * @param index
     * @param target
     * @return
     */
    private static boolean recur(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index == nums.length) {
            return false;
        }
        // 添加当前结点或者不添加当前节点
        return recur(nums, index + 1, target - nums[index]) || recur(nums, index + 1, target);
    }

}
