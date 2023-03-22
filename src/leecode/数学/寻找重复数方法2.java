package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/21:12
 * @Description:
 */
public class 寻找重复数方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    /**
     * 快慢指针，这个思路跟寻找链表的入环点思路一样，快指针每次走1步，慢指针每次走2步，当快慢指针相遇时，
     * 就把慢指针放到起点，然后快慢指针每次走1步，那么再相遇时就是入环点，也就是重复元素！
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
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

