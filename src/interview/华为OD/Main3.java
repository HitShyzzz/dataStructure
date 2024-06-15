package interview.华为OD;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-11 22:13
 */
public class Main3 {
    public static void main(String[] args) {
        int[][] roomTimes = {{1, 4}, {2, 5}, {7, 9}, {14, 18}};
        int[][] merge = merge(roomTimes);
        System.out.println(Arrays.deepToString(merge));
    }

    public static int[][] merge(int[][] roomTimes) {
        Arrays.sort(roomTimes, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < roomTimes.length; i++) {
            int start = roomTimes[i][0];
            int end = roomTimes[i][1];
            if (cnt == 0 || ans.get(cnt - 1)[1] < start) {
                ans.add(roomTimes[i]);
                cnt++;
            } else {
                ans.get(cnt - 1)[1] = Math.max(ans.get(cnt - 1)[1], end);
            }
        }
        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
