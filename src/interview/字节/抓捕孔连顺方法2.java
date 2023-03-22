package interview.字节;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/15/17:19
 * @Description:
 */
public class 抓捕孔连顺方法2 {
    public static void main(String[] args) {
        int N = 4;
        int D = 3;
        int[] nums = {1, 2, 3, 4};
        long i = solve(N, D, nums);
        System.out.println(i);
    }

    /**
     * 把最后一个定了，不算最后一个数，前面有j-i-1个数字任意挑选两个就好！
     *
     * @param N
     * @param D
     * @param nums
     * @return
     */
    public static long solve(int N, int D, int[] nums) {
        long cnt = 0;
        for (int i = 0, j = i + 2; i < N - 2; i++) {
            while (j < N && nums[j] - nums[i] <= D) {
                j++;
            }
            long p = j - i - 1;
            cnt += p * (p - 1) / 2;
        }
        return cnt % 99997867;
    }
}
