package leecode.排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/21:25
 * @Description:
 */
public class KthLargest {
    List<Integer> list;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return list.get(k - 1);
    }
}
