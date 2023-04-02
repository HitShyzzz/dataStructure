package interview.用友;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/16:07
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        long l = countPairsNum(nums, k);
        System.out.println(l);
    }

    // [1,2,3,4,5],2
    // 7

    /**
     * if x*y%k==0,那么必有grid(x,k)*grid(y,k)%k==0,
     * 其中grid(x,k)表示的是x和k的最大公约数！
     * 但还是会超时/(ㄒoㄒ)/~~
     * @param nums
     * @param k
     * @return
     */
    public static long countPairsNum(int[] nums, int k) {
        // write code here
        long ans = 0;
        // key是num和k的最大公约数，value是最大公约数的个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int gridNum = grid(num, k);
            map.put(gridNum, map.getOrDefault(gridNum, 0) + 1);
        }
        for (Integer key1 : map.keySet()) {
            for (Integer key2 : map.keySet()) {
                if (key1 <= key2 && (1l * key1 * key2 % k == 0)) {
                    long value1 = (long) map.get(key1);
                    long value2 = (long) map.get(key2);
                    if (key1 < key2) {
                        ans += (value1 * value2);
                    } else {
                        // 此时k1==k2，那么v1==v2，于是就变成了从v1个数中挑出来2个即可，Cv1 2
                        ans += value1 * (value1 - 1) / 2;
                    }
                }
            }
        }
        return ans;
    }

    // 求a和b的最大公约数
    public static int grid(int a, int b) {
        return b == 0 ? a : grid(b, a % b);
    }
}
