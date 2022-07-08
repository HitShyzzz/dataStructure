package leecode.位运算;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/15:47
 * @Description:
 */
public class 只出现一次的数字方法2 {
    public static void main(String[] args) {
        int a = 1;
        int[] nums = {4, 1, 2, 1, 2};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    /**
     * 位运算，核心思路就是a^0=a,a^a=0;那么设nums数组中出现两次的是a1,a2,...am,出现1次的是am+1.则
     * a1^a1^a2^a2^...^am^am^am+1=0^am+1=am+1;
     * O(T)=O(n);每个元素都需要遍历一次！
     * O(S)=O(1);没有使用额外的空间！
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
