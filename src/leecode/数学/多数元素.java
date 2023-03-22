package leecode.数学;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/17:22
 * @Description:
 */
public class 多数元素 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 利用hashMap来统计每个元素的次数，次数超过n/2的就是答案；
     * O(T)=O(n)
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }

}
