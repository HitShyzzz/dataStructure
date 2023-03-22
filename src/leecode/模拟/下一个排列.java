package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/22/11:35
 * @Description:
 */
public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        reverse(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 核心思想就是下一个排列应该让这个序列变大，但变大的幅度最小！
     * 因此我们要找到一个较大数尽可能靠右，较小数尽可能靠左，交换较大数和较小数，
     * 此时较大数右侧的序列一定是降序的，改成升序即可！
     *O(T)=O(n)，至多需要扫描两次，和一次翻转数列
     * O(S=O(1)；
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 先从后向前遍历找到第一个满足nums[i+1]>nums[i]的数对，那么nums[i]就是较小数
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                // 在[i+1,n]从后向前找第一个满足nums[j]>nums[i]的元素，那么nums[j]就是较大数
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        // 交换较大数和较小数
                        swap(nums, i, j);
                        break;
                    }
                }
                // 此时[i+1,n]一定是降序的，把[i+1,n]改成升序的即可!
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        // 如果没有找到满足nums[i+1]>nums[i]的数对，说明此时nums数组已经是降序的了，只需改成升序的就行！
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * 交换nums[i]和nums[j]
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 把降序序列nums[i,j]变成升序，利用双指针，一一交换元素即可；
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
