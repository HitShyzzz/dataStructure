package interview.字节;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/15/17:19
 * @Description:
 */
public class 抓捕孔连顺 {
    public static int cnt = 0;

    public static void main(String[] args) {
        int N = 5;
        int D = 19;
        int[] nums = {1, 10, 20, 30, 50};
        int i = solve(N, D, nums, 0, N - 1);
        System.out.println(i);
    }

    /**
     * 暴力递归，但是超时！！！
     *
     * @param N
     * @param D
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public static int solve(int N, int D, int[] nums, int i, int j) {
        if (j < i + 2 || i == N || j < 0) {
            return 0;
        }
        if (nums[j] - nums[i] <= D) {
            cnt = j - i - 1;
        }
        cnt += (solve(N, D, nums, i + 1, j) % 99997867) + (solve(N, D, nums, i, j - 1) % 99997867);
        return cnt % 99997867;
    }
}
