package interview.美团;

/**
 * Created with IntelliJ IDEA.
 * 快速排序最坏时间复杂度是O(n^2),平均时间复杂度是O(nlogn),空间复杂度是O(logn),（递归空间栈的调用）
 * 最坏情况下空间复杂度是O(n)，
 * 不稳定的算法，可能会把两个相同的元素发生交换，而冒泡排序是稳定的！
 *
 * @Author: shy
 * @Date: 2022/09/13/9:58
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, -2, 2, 4, 1, 6};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int key = nums[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                // 从右向左找到第一个比主元小的元素
                while (i < j && nums[j] > key) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                // 从左向右找到第一个比主元大的元素
                while (i < j && nums[i] < key) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            // 相遇的位置设置为新的主元
            nums[i] = key;
            // 对主元以左进行完全相同的操作
            quickSort(nums, begin, i - 1);
            // 对主元以右进行完全相同的操作
            quickSort(nums, i + 1, end);
        }
    }
}
