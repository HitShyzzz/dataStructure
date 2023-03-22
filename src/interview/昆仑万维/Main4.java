package interview.昆仑万维;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/05/20:10
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int i = max_wave_arr_len(arr);
        System.out.println(i);
    }

    public static int max_wave_arr_len(int[] arr) {
        // write code here
        int n = arr.length;
        int ans = 1;
        int dp0 = 1;
        int dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i] < arr[i - 1]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }
}