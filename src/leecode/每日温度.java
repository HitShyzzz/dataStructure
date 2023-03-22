package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/10/22:10
 * @Description:
 */
public class 每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {30, 60, 90};
        int[] dailyTemperatures = dailyTemperatures(temperatures);
        for (int i : dailyTemperatures) {
            System.out.print(i + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
