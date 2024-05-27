package leecode.每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-18 14:28
 */
public class 找出可整除性得分最大的整数 {
    public static int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        Set<Integer> set = new HashSet<>();
        int ans = divisors[0];
        int maxCnt = 0;
        for (int div : divisors) {
            if (set.contains(div)) {
                continue;
            }
            set.add(div);
            int count = (int) Arrays.stream(nums).filter(num -> num % div == 0).count();
            if (count > maxCnt) {
                maxCnt = count;
                ans = div;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {20, 14, 21, 20, 15};
        int[] divisors = {5, 7, 5};
        System.out.println(maxDivScore(nums, divisors));
    }
}
