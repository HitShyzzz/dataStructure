package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/15:48
 * @Description:
 */
public class 最少操作次数使得数组元素相等 {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int cnt = 0;
        // n-1个元素加1，就相等于1个元素减1
        for (int num : nums) {
            cnt += (num - min);
        }
        return cnt;
    }
}
