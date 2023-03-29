package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/27/8:39
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[]nums={1,-2,3,7,3,5,4};
        quickSort(nums,0, nums.length-1);
        for(int num :nums){
            System.out.print(num+" ");
        }
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && nums[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                while (i < j && nums[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                }
            }
            pivot = nums[i];
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

}
