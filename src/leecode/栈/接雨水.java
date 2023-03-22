package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/24/9:27
 * @Description:
 */
public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 暴力解法，我们对于每个结点依次去求它能接到的雨水，然后把所有点接到的雨水累加起来，就是所有能接到的雨水
     * 而结点height[i]接到的雨水等于Math.min(maxLeft,maxRight)-height[i]，maxLeft表示从当前位置向左最高的柱子的高度，
     * maxRight表示从当前位置向右最高的柱子的高度；
     * O(T)=O(n^2);
     * O(S)=O(1);
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 之所以把这两个变量写到循环里面，是为了避免前面的maxLeft,maxRight对后面的造成影响！
            int maxLeft = 0;
            int maxRight = 0;
            // 向左去找maxLeft
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 向右去找maxRight
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += (Math.min(maxLeft, maxRight) - height[i]);
        }
        return ans;
    }
}
