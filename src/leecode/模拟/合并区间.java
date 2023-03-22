package leecode.模拟;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/11:07
 * @Description:
 */
public class 合并区间 {
    /**
     * 先把区间按照start从小到大排序，然后再按照end从小到大排序；
     * 排序之后如果有重叠的话，再合并就好了！
     * 这里合并的时候直接从list末尾比较来合并是比较好的，值得学习！
     * O(T)=O(nlogn);只需要一次扫描，主要的时间开销是花在排序上了；
     * O(S)=O(logn);忽略存储结果的空间开销，排序需要的空间是O(logn);
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        // 保存结果集合
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // 当没有重叠时！
            if (list.size() == 0 || start > list.get(list.size() - 1)[1]) {
                list.add(new int[]{start, end});
            } else {// 当有重叠时！start还是原来的start，end是原来的end和新的end的较大值！
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], end);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
