package interview.字节;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/18/11:22
 * @Description:
 */
public class 特征提取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxLen = 1;
        int N = in.nextInt();
        while (N > 0) {
            int M = in.nextInt();
            Map<int[], Integer> preMap = new HashMap<>();
            while (M > 0) {
                int F = in.nextInt();
                Map<int[], Integer> curMap = new HashMap<>();
                for (int i = 0; i < F; i++) {
                    int[] nums = new int[2];
                    nums[0] = in.nextInt();
                    nums[1] = in.nextInt();
                    curMap.put(nums, 1);
                    for (int[] keys : preMap.keySet()) {
                        if (keys[0] == nums[0] && keys[1] == nums[1]) {
                            int len = preMap.get(keys) + 1;
                            curMap.put(nums, len);
                            maxLen = maxLen > len ? maxLen : len;
                        }
                    }
                }
                preMap = curMap;
                M--;
            }
            N--;
        }
        System.out.println(maxLen);
    }

}
