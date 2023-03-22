package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/11:12
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -9, 5, 4};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        //boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                   // isSorted = false;
                }
            }
//            if (isSorted) {
//                break;
//            }
        }
    }
}
