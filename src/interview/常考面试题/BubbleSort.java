package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/27/8:57
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 7, 3, 5, 4};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
