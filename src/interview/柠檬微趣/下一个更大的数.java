package interview.柠檬微趣;

import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/11/16:52
 * @Description:
 */
public class 下一个更大的数 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(13);
        list.add(10);
        list.add(5);
        list.add(12);
        list.add(21);
        list.add(3);
        List<Integer> num = largerNum(list);
        for (Integer i : num) {
            System.out.print(i + " ");
        }
    }

    // 11,13,10,5,12,21,3
    // 12,21,12,12,21,-1,-1
    // O(n^2)会超时！
    public static List<Integer> largerNum(ArrayList<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        int n = list.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = list.get(i);
            int value = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) > cur) {
                    value = Math.min(value, list.get(j));
                }
            }
            nums[i] = (value == Integer.MAX_VALUE ? -1 : value);
        }
        ans = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return ans;
    }

}
