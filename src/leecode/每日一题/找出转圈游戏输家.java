package leecode.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/16/20:25
 * @Description:
 */
public class 找出转圈游戏输家 {
    public int[] circularGameLosers(int n, int k) {
        if (n == 1) {
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>();
        int cur = 1;
        int i = 1;
        while (set.add(cur)) {
            cur = (cur + i * k) % n;
            i++;
        }
        int cnt = set.size();
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            if (!set.contains(j)) {
                list.add(j);
            }
        }
        int[] ans = new int[n - cnt];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = list.get(j);
        }
        Arrays.sort(ans);
        return ans;
    }
}
