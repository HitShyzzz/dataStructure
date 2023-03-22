package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/03/12:27
 * @Description:
 */
public class 连续整数求和 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            n = n - i + 1;
            if (n % i == 0) {
                ans++;
            }
        }
        return ans;
    }
}
