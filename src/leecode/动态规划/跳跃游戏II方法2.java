package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/20:13
 * @Description:
 */
public class 跳跃游戏II方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        int b = jump(nums);
        System.out.println(b);
    }

    /**
     * 贪心算法，我们贪心的让每走一步都争取能走的最远，直到到达最后一个位置！
     *O(T)=O(n);一次遍历就好了；
     * O(S)==O(1)；
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int step = 0;// 记录总共走的步数
        int rightMost = 0;// 记录每一步最远到达的位置
        int end = 0;// 记录当前能到达的最远的边界
        for (int i = 0; i < n - 1; i++) {
            // 最远能到达的位置
            rightMost = Math.max(rightMost, i + nums[i]);
            // 如果走这一步已经能到最后了，那么就步数+1，结束循环！
            if (rightMost >= n - 1) {
                step++;
                break;
            }
            // 如果遍历到了边界，那么才去更新新的边界就是新的最远的能到达的位置，
            if (i == end) {
                end = rightMost;
                step++;
            }
        }
        return step;
    }

}
