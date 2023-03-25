package leecode.数学;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/15:48
 * @Description:
 */
public class 最少操作次数使得数组元素全不相同 {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        int i = minMoves(nums);
        System.out.println(i);
    }

    // 1 2 2 3 4 5 5 7
    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int num : nums) {
            int cur = num;
            while (set.contains(cur)) {
                cur--;
                cnt++;
            }
            set.add(num);
        }
        return cnt;
    }
}
