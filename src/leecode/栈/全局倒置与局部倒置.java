package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/16/9:34
 * @Description:
 */
public class 全局倒置与局部倒置 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        boolean idealPermutation = isIdealPermutation(nums);
        System.out.println(idealPermutation);
    }

    // 暴力方法，时间复杂度可达到O(n^2)，部分用例过不去！
    public static boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    if (j == i + 1) {
                        count1++;
                    }
                    count2++;
                }
            }
        }
        return count1 == count2;
    }
}
