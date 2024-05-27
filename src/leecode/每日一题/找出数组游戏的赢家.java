package leecode.每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-19 10:47
 */
public class 找出数组游戏的赢家 {
    public static void main(String[] args) {
        int[] arr = {1, 25, 35, 42, 68, 70};
        int k = 2;
        System.out.println(getWinner(arr, k));
    }

    // 输入：arr = [2,1,3,5,4,6,7], k = 2
    // 输出：5
    public static int getWinner(int[] arr, int k) {
        // 记录每个最大值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int res = 0;
        int max = 0;
        boolean flag=true;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(arr[i], arr[i + 1]);
            map.put(max, map.getOrDefault(max, 0) + 1);
            if (map.get(max) == k) {
                flag=false;
                res = max;
                break;
            }
            arr[i + 1] = max;
        }
        return k > n || flag ? max : res;
    }
}
