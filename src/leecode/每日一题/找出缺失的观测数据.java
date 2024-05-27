package leecode.每日一题;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-27 20:23
 */
public class 找出缺失的观测数据 {
    public static void main(String[] args) {
        int[] rolls = {4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5};
        int mean = 4;
        int n = 40;
        int[] ints = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(ints));
    }

    static List<Integer> list = new ArrayList<>();
    static int[] res;

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int target = mean * (m + n) - sum;
        dfs(target, n);
        return res == null ? new int[]{} : res;
    }
    /**
     * @description: 递归回溯，又超时了，呜呜
     * @author: shy
     * @date: 2024/5/27 21:37
     * @param:
     * @param: target
     * @param: n
     * @return: void
     **/
    static void dfs(int target, int n) {
        if (target < 0 || (n <= 0 && target != 0)) {
            return;
        }
        if (target == 0 && n == 0) {
            res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return;
        }
        for (int i = 6; i >= 1; i--) {
            list.add(i);
            dfs(target - i, --n);
            list.remove(list.size() - 1);
            ++n;
        }
    }
}
