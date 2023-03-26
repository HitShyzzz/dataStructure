package leecode.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/15:10
 * @Description:
 */
public class 主持人调度一 {
    /**
     *
     * @param schedule int整型ArrayList<ArrayList<>>
     * @return bool布尔型
     */
    public boolean hostschedule (ArrayList<ArrayList<Integer>> schedule) {
        // write code here
        Collections.sort(schedule, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer>l1, ArrayList<Integer> l2) {
                return l1.get(0) != l1.get(0) ? l1.get(0) - l2.get(0) : l1.get(1) - l2.get(1);
            }
        });
        for(int i=0;i<schedule.size()-1;i++){
            // 排序后，如果当前的end>下一个的start，就说明有重叠，直接返回false；
            if(schedule.get(i).get(1)>schedule.get(i+1).get(0)){
                return false;
            }
        }
        return true;
    }
}
