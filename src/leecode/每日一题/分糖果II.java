package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-03 20:16
 */
public class 分糖果II {
    public static void main(String[] args) {
        int candies = 7;
        int num_people = 4;
        int[] ints = distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(ints));
    }

    // 输入：candies = 7, num_people = 4
    // 输出：[1,2,3,1]
    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            int cur = Math.min(candies, i + 1);
            ans[i % num_people] += cur;
            candies -= cur;
            i++;
        }
        return ans;
    }
}
