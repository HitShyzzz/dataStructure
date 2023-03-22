package interview.TPLINK;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/19/16:06
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
