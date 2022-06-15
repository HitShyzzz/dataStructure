package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/03/12:48
 * @Description:
 */
public class 连续整数求和方法2 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int k = 1; k * (k + 1) <= 2 * n; k++) {
            if (isConsecutiveK(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 判断连续k个数之和是否为n;
     *
     * @param n
     * @param k
     * @return
     */
    public boolean isConsecutiveK(int n, int k) {
        // k是奇数
        if (k % 2 == 1) {
            return n % k == 0;
        } else {// k是偶数
            return n % k != 0 && ((2 * n) % k == 0);
        }

    }
}
