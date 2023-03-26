package leecode.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/19:49
 * @Description:
 */
public class 合并区间 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return ans;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start == v2.start ? v1.end - v2.end : v1.start - v2.start;
            }
        });
        ans.add(intervals.get(0));
        int count = 0;// 记录的是ans的末尾下标
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            // 结果集的最后一个！
            Interval pre = ans.get(count);
            // 没重叠
            if (cur.start > pre.end) {
                ans.add(cur);
                count++;
            } else {// 有重叠
                // 要先把末尾的移除
                ans.remove(count);
                Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
                ans.add(merged);
            }
        }
        return ans;
    }
}

class Interval {
    int start;
    int end;

    public Interval() {

    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
