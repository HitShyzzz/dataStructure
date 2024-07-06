package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-06 13:42
 */
public class 颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    // 输入：nums = [2,0,2,1,1,0]
    // 输出：[0,0,1,1,2,2]
    public static void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // 手写快速排序
    public static void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        // 主元
        int priov = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            // 比主元大的元素放在主元右边
            while (j > i && nums[j] > priov) {
                j--;
            }
            // 比主元小，nums[j]<=priov,交换i和j，nums[i]再和主元进行比较
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                // 交换完成之后，比主元小的元素已经在主元左侧了，i++进行下一个元素判断
                i++;
            }
            // 比主元小，就放i在主元左边
            while (i < j && nums[i] < priov) {
                i++;
            }
            // 比主元大，交换i和j，下一轮循环nums[j]再和主元做比较
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
        // 这样就找到了主元的位置是确定的
        nums[i] = priov;
        // 对主元左侧递归
        sort(nums, l, i - 1);
        // 对主元右侧递归
        sort(nums, i + 1, r);
    }
}
