package leecode.每日一题;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-01-24 21:21
 */
public class 美丽塔I {
    public static void main(String[] args) {
        List<Integer> maxHeights = Arrays.asList(5, 2, 4, 4);
        long l = maximumSumOfHeights(maxHeights);
        System.out.println(l);
    }

    // 输入：maxHeights = [3,2,5,5,2,3]
    // 输出：18
    // 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
    // - 1 <= heights[i] <= maxHeights[i]
    // - heights 是个山脉数组，最大值在 i = 2 处。
    // 注意，在这个方案中，i = 3 也是一个峰值。
    // 18 是所有美丽塔方案中的最大高度和。
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();
        for (int i = 0; i < n; i++) {
            long sum = maxHeights.get(i);
            long left = sum;
            for (int j = i - 1; j >= 0; j--) {
                left = Math.min(left, maxHeights.get(j));
                sum += left;
            }
            long right = maxHeights.get(i);
            for (int j = i + 1; j < n; j++) {
                right = Math.min(right, maxHeights.get(j));
                sum += right;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
