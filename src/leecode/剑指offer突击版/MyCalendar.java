package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/10:06
 * @Description:
 */
public class MyCalendar {
    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] num : list) {
            if (num[0] < end && num[1] > start) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
