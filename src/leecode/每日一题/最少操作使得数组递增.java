package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/11/13:02
 * @Description:
 */
public class 最少操作使得数组递增 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 4, 1};
        int i = minOperations(nums);
        System.out.println(i);

    }

    public static int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int d = nums[i] - nums[i + 1];
            // 不递增了
            if (d >= 0) {
                ans += (d + 1);
                nums[i + 1] = nums[i] + 1;
            }
        }
        return ans;
    }
}
