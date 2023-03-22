package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/11:17
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
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
                while (i < j && nums[j] > key) {
                    j--;
                }
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                while (i < j && nums[i] < key) {
                    i++;
                }
                if (i < j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j--;
                }
            }
            nums[i] = key;
            quickSort(nums, begin, i - 1);
            quickSort(nums, i + 1, end);
        }
    }
}
