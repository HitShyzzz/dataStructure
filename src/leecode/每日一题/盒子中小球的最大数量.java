package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/23/9:32
 * @Description:
 */
public class 盒子中小球的最大数量 {
    public static void main(String[] args) {
        int lowLimit = 5;
        int highLimit = 15;
        int i = countBalls(lowLimit, highLimit);
        System.out.println(i);
    }

    // lowLimit = 5, highLimit = 15-----》2
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();// 存放每个盒子的小球数量
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = sum(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > ans) {
                ans = map.get(key);
            }
        }
        return ans;
    }

    /**
     * @param n
     * @return 整数n的每一位之和
     */
    public static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
