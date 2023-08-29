package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/27/16:32
 * @Description:
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    // 输出：[[1,6],[8,10],[15,18]]
    // 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public static int[][] merge(int[][] intervals) {
        // start和end都从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // 合并区间
            if (list.get(list.size() - 1)[1] >= start) {
                int cur[] = list.remove(list.size() - 1);
                int newEnd = Math.max(cur[1], end);
                list.add(new int[]{cur[0], newEnd});
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
