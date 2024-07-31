package leecode.每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-31 9:30
 */
public class 覆盖所有点的最少矩形数目 {
    public static void main(String[] args) {
        int[][] points = {{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
        int w = 1;
        int i = minRectanglesToCoverPoints(points, w);
        System.out.println(i);
    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        int cnt = 0;
        // 矩形的右边界
        int bound = -1;
        // 只与X有关，将x坐标从小到大排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        for (int[] point : points) {
            // 当前x超过了矩形的右边界，就要新加一个矩形
            if (point[0] > bound) {
                // 新的右边界为xi+w
                bound = point[0] + w;
                // 新增矩形
                cnt++;
            }
        }
        return cnt;
    }
}
