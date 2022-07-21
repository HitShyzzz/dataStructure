package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/23:05
 * @Description:
 */
public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int ways = findTargetSumWays(nums, target);
        System.out.println(ways);
    }

    private static int count = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        recur(nums, 0, target, 0);
        return count;
    }

    /**
     * 对于每个元素其实都有+，-两种符号可以选择，那么共有2^n个表达式，因此总的时间复杂度就是O(2^n);
     * O(S)=O(n);
     * @param nums
     * @param index
     * @param target
     * @return
     */
    public static void recur(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        // nums[index]前面符号是'+';
        recur(nums, index + 1, target, sum + nums[index]);
        // nums[index]前面符号是'-';
        recur(nums, index + 1, target, sum - nums[index]);
    }
}
