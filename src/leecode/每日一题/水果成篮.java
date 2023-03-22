package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/17/12:56
 * @Description:
 */
public class 水果成篮 {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int i = totalFruit(fruits);
        System.out.println(i);
    }
    // 滑动窗口
    public static int totalFruit(int[] fruits) {
        int ans = 0;
        int n = fruits.length;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> window = new HashMap<>();
        while (right < n) {
            int a = fruits[right];
            window.put(a, window.getOrDefault(a, 0) + 1);
            while (window.size() > 2) {
                int b = fruits[left];
                window.put(b, window.get(b) - 1);
                if (window.get(b) == 0) {
                    window.remove(b);
                }
                left++;
            }
            right++;
            ans = Math.max(right - left, ans);
        }
        return ans;
    }
}
