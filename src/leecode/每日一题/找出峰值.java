package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-28 20:25
 */
public class 找出峰值 {
    // 输入：mountain = [1,4,3,8,5]
    // 输出：[1,3]
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        int n = mountain.length;
        for (int i = 0; i + 2 < n; i++) {
            if (mountain[i + 1] > mountain[i] && mountain[i + 1] > mountain[i + 2]) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
