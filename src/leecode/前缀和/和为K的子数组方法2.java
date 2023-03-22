package leecode.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/21:03
 * @Description:
 */
public class 和为K的子数组方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    /**
     * 前缀和+hashMap优化！
     * 设pre[i]表示[0,i]内nums元素之和，那么区间[j,i]内nums元素之和为k就可以表示为pre[i]-pre[j-1]=k.
     * 那么pre[j-1]=pre[i]-k;因此对于每个i，我们只要去列举pre[j]=pre[i]-k的j的个数就好了，
     * 我们可以利用hashMap记录pre[i]出现的次数，
     * 同时可以利用滚动数组用变量pre代替数组pre;
     * O(T)=O(n);只需要一次遍历
     * O(S)=O(n);需要用O(n)的hashMap去记录前缀和出现的次数！
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int pre = 0;// 记录前缀和
        map.put(0, 1);// 涵盖某个元素就等于k的情况
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
