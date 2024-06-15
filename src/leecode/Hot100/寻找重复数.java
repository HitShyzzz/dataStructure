package leecode.Hot100;

import java.awt.event.WindowListener;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 17:19
 */
public class 寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    // 输入：nums = [1,3,4,2,2]
    // 输出：2
    // 快慢指针
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }
}
