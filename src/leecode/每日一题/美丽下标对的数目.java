package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-20 22:23
 */
public class 美丽下标对的数目 {
    public static void main(String[] args) {
        int[] nums = {11, 21, 12};
        int i = countBeautifulPairs(nums);
        System.out.println(i);
    }

    // 输入：nums = [11,21,12]
    // 输出：2
    // 解释：共有 2 组美丽下标对：
    // i = 0 和 j = 1 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 1 。gcd(1,1) == 1 。
    // i = 0 和 j = 2 ：nums[0] 的第一个数字是 1 ，nums[2] 的最后一个数字是 2 。gcd(1,2) == 1 。
    // 因此，返回 2 。
    public static int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int a = nums[i] % 10;
            for (int j = 0; j < i; j++) {
                int b = getHighest(nums[j]);
                if (grid(a, b) == 1)
                    ans++;
            }
        }
        return ans;
    }

    public static int grid(int a, int b) {
        if (a % b == 0)
            return b;
        return grid(b, a % b);
    }

    // 求整数a的最高位元素
    public static int getHighest(int a) {
        if (a < 10)
            return a;
        while (a >= 10) {
            a = a / 10;
        }
        return a;
    }
}
