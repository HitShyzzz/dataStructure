package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/05/12:39
 * @Description:
 */
public class 和为k的子数组方法2 {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;// 用来记录从下标0到i的元素和，即前缀和
        int count = 0;// 用来记录和为k的子数组个数
        Map<Integer, Integer> map = new HashMap<>();// 用来记录前缀和出现的次数，key为前缀和，value是对应出现的次数
        // 这里是为了解决从nums[0]+...+nums[i]恰好为k的情况，举个例子一看就明白了；
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // pre[i]=pre[i-1]+nums[i],因此可以用变量pre来代pre数组
            pre += nums[i];
            // 如果子数组nums[j],...nums[i]和恰为k,则必有pre[i]-pre[j-1]=k.即pre[j-1]=pre[i]-k;因此我们只需要统计前缀和为pre[i]-k的次数
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
