package interview.衍复;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 滑动窗口
 * @date: 2024-06-30 21:42
 */
public class 水果成篮 {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int i = totalFruit(fruits);
        System.out.println(i);
    }

    // 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
    // 输出：5
    // 解释：可以采摘 [1,2,1,1,2] 这五棵树。
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        // 窗口左边界
        int l = 0;
        // 窗口右边界
        int r = 0;
        int ans = 0;
        // key是水果的种类，value是当前种类水果的数量
        Map<Integer, Integer> map = new HashMap<>();
        // 右边界控制往窗口里加元素
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                int x = fruits[l];
                // 左边界收缩窗口
                map.put(x, map.get(x) - 1);
                // 当元素数量为0时，就移除当前元素
                if (map.get(x) == 0) {
                    map.remove(x);
                }
                l++;
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
