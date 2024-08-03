package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 双指针
 * @date: 2024-08-03 13:25
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(height);
        System.out.println(i);
    }

    // 输入：[1,8,6,2,5,4,8,3,7]
    // 输出：49
    // 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    public static int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l]);
                // 每次移动高度矮的指针
                l++;
            } else {
                res = Math.max(res, (r - l) * height[r]);
                r--;
            }
        }
        return res;
    }
}
