package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/17:35
 * @Description:
 */
public class 跳跃游戏方法2 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    /**
     * 对于每个位置我们贪心的让他跳到最远，如果有某一步我们跳到最远的地方>=n-1,说明就能到达最后了，就可以返回true了！
     * O(T)=O(n);一次遍历就好
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        // 记录最远能到达的位置！
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
            }
            if (rightMost >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
