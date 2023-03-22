package leecode.排序;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/16:19
 * @Description:
 */
public class 数组中的第K个最大元素方法4 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    /**
     * 快速选择算法，是基于快速排序的改进，我们只关注排序后的倒数第K个元素，因此递归的时候如果q是我们要找的目标
     * 直接返回nums[q];如果q<target,那么就去递归右边的区间；如果q>target,那么就去递归左边的区间；
     * 快速排序最坏情况下时间复杂度可以达到O(n^2),为了优化时间复杂度引入了随机化过程把时间复杂度优化到O(n);
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.46%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了56.99%的用户
     * O(T)=O(n);
     * O(S)=O(logn);
     * 这里不随机化也能返回结果，但时间复杂度是比较高的!最坏可以达到O(n^2);
     *
     * @param nums
     * @param k
     * @return
     */
    private static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * @param nums
     * @param l     左边界
     * @param r     有边界
     * @param index 目标下标
     * @return
     */
    public static int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        // q是我们要找的目标，就停下来！
        if (q == index) {
            return nums[q];
        } else if (q < index) {// q<index,就去右半边找
            return quickSelect(nums, q + 1, r, index);
        } else {// q>index,就去左半边找
            return quickSelect(nums, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;// 返回[l,r]内的一个随机数
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    /**
     * @param nums
     * @param l
     * @param r
     * @return 返回快速排序主元的下标！此主元的下标就是排好序之后的下标位置！
     */
    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            // 把比主元下的都交换到左边去
            if (nums[j] < pivot) {
                swap(nums, ++i, j);
            }
        }
        // 这个循环走完，所有比主元小的都在左边了，主元的位置就在i+1;
        swap(nums, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
