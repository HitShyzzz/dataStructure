package leecode.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/18/21:57
 * @Description:
 */
public class 数位和相等数对的最大和 {

    public static void main(String[] args) {
//        int sum = sum(4366743);
//        System.out.println(sum);
        int[] nums = {279, 169, 463, 252, 94, 455, 423, 315, 288, 64, 494, 337, 409, 283, 283, 477, 248, 8, 89, 166, 188, 186, 128};
        int i = maximumSum(nums);
        System.out.println(i);
    }

    // 输入：nums = [18,43,36,13,7]
    // nums =
    //[368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183]
    // 输出：54
    // 解释：满足条件的数对 (i, j) 为：
    // - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
    // - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
    //所以可以获得的最大和是 54 。
    public static int maximumSum(int[] nums) {
        long max = 0;
        Arrays.sort(nums);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = sum(nums[i]);
            if (map.containsKey(sum)) {
                max = Math.max(max, map.get(sum) + nums[i]);
            }
            map.put(sum, (long) nums[i]);
        }
        return map.size() == nums.length ? -1 : (int) max;
    }

    // 求整数每位的和
    public static int sum(int a) {
        int res = 0;
        while (a != 0) {
            res += a % 10;
            a = a / 10;
        }
        return res;
    }
}
