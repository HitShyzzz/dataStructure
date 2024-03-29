package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/27/9:08
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 7, 3, 5, 4};
        insertSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 插入排序，O(T)=O(n^2),O(S)=O(1),稳定的排序算法
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && tmp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = tmp;
            }
        }
    }
}
