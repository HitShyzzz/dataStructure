package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/17:04
 * @Description:
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 7, 3, 5, 4};
        selectedSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 选择排序，O(T)=O(n^2),O(S)=O(1),稳定的排序算法
     * @param nums
     */
    public static void selectedSort(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }

}
