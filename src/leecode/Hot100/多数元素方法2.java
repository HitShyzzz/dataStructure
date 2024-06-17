package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 20:46
 */
public class 多数元素方法2 {
    // 输入：nums = [2,2,1,1,1,2,2]
    // 输出：2
    // 投票算法
    // O(S)=O(1)
    public int majorityElement(int[] nums) {
        int candidate = 0;// 候选人
        int count = 0;// 计票
        for (int num : nums) {
            if (count == 0) candidate = num;// 票数为0，发生换届
            // 如果候选人不是maj，那么maj和其他非候选人会一起投反对票
            // 如果候选人是maj，那么maj自己和支持它的人会给它投票，因为它的票数大于N/2，那么它一定能当选
            count += (candidate == num ? 1 : -1);
        }
        return candidate;
    }
}
