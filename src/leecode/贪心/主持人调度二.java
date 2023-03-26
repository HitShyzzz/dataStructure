package leecode.贪心;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/15:10
 * @Description:
 */
public class 主持人调度二 {
    /**
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型 成功举办活动需要多少名主持人
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 当前start>=上面一个的end，就说明这个节目不需要再额外安排人，让前一个主持人接着干活就行！
            if (start[i] >= end[j]) {
                j++;
            } else {// 有重叠了就要增加主持人
                res++;
            }
        }
        return res;
    }
}
