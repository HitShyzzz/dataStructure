package leecode.每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-31 20:36
 */
public class 找出缺失和重复的数字 {
    public static void main(String[] args) {
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int repeat = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] row : grid) {
            for (int i : row) {
                if (set.contains(i)) {
                    repeat = i;
                }
                set.add(i);
            }
            sum += Arrays.stream(row).sum();
        }
        int miss = repeat + (1 + n * n) * (n * n) / 2 - sum;
        return new int[]{repeat, miss};
    }
}
