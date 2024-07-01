package leecode.Hot100;
import java.util.Arrays;
/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划，O(T)=O(N),O(S)=O(N)
 * @date: 2024-07-01 22:18
 */
public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int n = height.length;
        // left[i]表示i左侧比height[i]最高的高度
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        System.out.println(Arrays.toString(left));
        // right[i]表示i右侧比height[i]最高的高度
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(right));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 第i根柱子的贡献=left[i]和right[i]较小者-height[i]
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
