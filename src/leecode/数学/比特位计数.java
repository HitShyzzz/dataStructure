package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/22:58
 * @Description:
 */
public class 比特位计数 {
    /**
     * 计算n的二进制1的个数只需要不停的和n-1取与运算，知道n=0,
     * O(T)=O(nlogn),对于每一位都需要取计算1的个数，每次计算时间复杂度不超过O(logn),因此总的时间复杂度就是O(nlogn);
     * O(S)=O(1),不算返回结果集的额外空间！
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    public int count(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= n - 1;
        }
        return cnt;
    }
}
