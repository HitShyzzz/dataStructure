package leecode.贪心;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/20:41
 * @Description:
 */
public class 分糖果 {
    public static void main(String[] args) {
        int[] arr = {10, 4, 10, 10, 4};
        int candy = candy(arr);
        System.out.println(candy);
    }

    /**
     * pick candy
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int candy(int[] arr) {
        // write code here
        int n = arr.length;
        int res = 0;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);// 先每人来一块
        // 从左往右遍历
        for (int i = 1; i < n; i++) {
            // 当前孩子比前一个孩子得分高
            if (arr[i] > arr[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 从右往左遍历
        for (int i = n - 2; i >= 0; i--) {
            // 如果当前孩子得分高，但是他的糖果数却小于等于后面这个孩子的糖果，当前孩子就要比后面孩子多一个糖果！
            if (arr[i] > arr[i + 1] && (nums[i] <= nums[i + 1])) {
                nums[i] = nums[i + 1] + 1;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
