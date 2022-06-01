package leecode.recur;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/01/16:17
 * @Description:
 */
public class 火柴拼正方形 {
    public boolean makesquare(int[] matchsticks) {
        // 先求出所有火柴长度的和，如果不是4的倍数那么一定不能拼成正方形
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        // 把火柴数组从大到小排序，减少搜索时间
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int len = sum / 4;
        int[] edges = new int[4];// 表示正方形的四条边，不断往4条边上加火柴，保证edges[i]<=len;
        return dfs(0, matchsticks, edges, len);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            // 回溯
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
