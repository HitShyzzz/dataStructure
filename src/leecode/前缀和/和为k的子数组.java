package leecode.前缀和;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/20:14
 * @Description:
 */
public class 和为k的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    /**
     * 列举nums数组的所有子数组，然后依次计算每个子数组的和，如果为k，就计数一次！
     * O(T)=O(n^2);
     * O(S)=O(1);
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
