package interview.柠檬微趣;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/11/21:50
 * @Description:
 */
public class 工作调度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int time = Integer.parseInt(s1[0]);
            int profit = Integer.parseInt(s1[1]);
            int max = 0;
            if (map.containsKey(time)) {
                if (map.get(time) > max) {
                    map.put(time, max);
                }
            }
            map.put(time, profit);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            ans += map.get(key);
        }
        System.out.println(ans);
    }

}

