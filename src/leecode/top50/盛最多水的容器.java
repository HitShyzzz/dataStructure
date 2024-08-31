package leecode.top50;

import java.util.WeakHashMap;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 双指针
 * @date: 2024-08-26 22:24
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        // 双指针l和r之间能接到的水就是(r-l)*min(height[l],height[r])
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, (r - l) * height[l]);
                // 人往高处走，往高的方向走，才可能会遇到更高的height
                l++;
            } else {
                ans = Math.max(ans, (r - l) * height[r]);
                // 往高的方向走
                r--;
            }
        }
        return ans;
    }
}
