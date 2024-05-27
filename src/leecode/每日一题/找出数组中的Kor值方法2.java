package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-06 20:10
 */
public class 找出数组中的Kor值方法2 {
    public static void main(String[] args) {
        int[] nums = {7, 12, 9, 8, 9, 15};
        int k = 4;
        int kOr = findKOr(nums, k);
        System.out.println(kOr);
    }

    // 输入：nums = [7,12,9,8,9,15], k = 4
    //输出：9
    //解释：nums[0]、nums[2]、nums[4] 和 nums[5] 的第 0 位的值为 1 。
    //nums[0] 和 nums[5] 的第 1 位的值为 1 。
    //nums[0]、nums[1] 和 nums[5] 的第 2 位的值为 1 。
    //nums[1]、nums[2]、nums[3]、nums[4] 和 nums[5] 的第 3 位的值为 1 。
    //只有第 0 位和第 3 位满足数组中至少存在 k 个元素在对应位上的值为 1 。因此，答案为 2^0 + 2^3 = 9 。
    public static int findKOr(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                // 拿到Nums[j]的第i位即可
                if ((nums[j] >> i & 1) != 0) {
                    cnt++;
                }
                if (cnt >= k) {
                    answer += (1 << i);
                    break;
                }
            }
        }
        return answer;
    }
}
