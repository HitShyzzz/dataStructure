package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/24/15:12
 * @Description:
 */
public class 接雨水方法4 {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 这里的思路是用双指针代替数组leftMax数组和rightMax数组，从而降低空间复杂度
     * O(T)=O(n)一次遍历就好，左右双指针同时开始收集雨水，太妙了！
     * O(S)=O(1);
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (l < r) {
            // height[l]<height[r]必然rightMax>leftMax,那么下标l处能接到的雨水就是leftMax-height[i];
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                ans += leftMax - height[l];
                l++;
            } else {// height[l]>=height[r]必然leftMax>=rightMax,那么下标r处能接到的雨水就是rightMax-height[r];
                rightMax = Math.max(rightMax, height[r]);
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
