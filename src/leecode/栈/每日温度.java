package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/16:07
 * @Description:
 */
public class 每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures1 = dailyTemperatures(temperatures);
        for (int t : temperatures1) {
            System.out.print(t + " ");
        }
    }

    /**
     * 两次遍历，如果第一次遇到t[j]>t[i],那么ans[i]=j-i;
     * O(T)=O(n^2);
     * O(S)=O(1);不算返回结果集占的额外空间！
     *
     * @param temperatures
     * @return
     */
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
