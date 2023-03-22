package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/24/10:29
 * @Description:
 */
public class 接雨水方法2 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 在方法1的基础上我们可以提前把leftMax和rightMax的值提前存好，然后还是
     * 对于第i个柱子能存的雨水是Math.min(leftMax,rightMax)-height[i]，再累积到结果变量中！
     * O(T)=O(n)；不管是算leftMax,rightMax,还是每个柱子存的雨水都是一遍扫描，
     * O(S)=O(n);需要O(n)的数组来存储leftMax和rightMax的值！
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];// 存放每个元素左边最高柱子的高度；
        maxLeft[0] = height[0];// 存放每个元素右边最高柱子的高度；
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }
        return ans;
    }
}
