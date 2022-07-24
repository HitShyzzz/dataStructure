package leecode.数学;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/22:00
 * @Description:
 */
public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    /**
     * 思路：先把数组排序，从前往后遍历原来数组，第一个和排序后不相同的位置就是无序连续子数组的起始位置start，
     * 同样的从后往前遍历原来数组，第一个和排序后不相同的位置就是无序连续子数组的终止位置end，
     * 那么最短无序连续子数组的长度就是end-start+1;
     * O(T)=O(nlogn),排序需要O(nlogn),遍历原数组需要O(n);
     * O(S)=O(n),需要O(n)的空间来存储复制后的数组！
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                start = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != copy[j]) {
                end = j;
                break;
            }
        }
        return (end == 0 && start == 0) ? 0 : end - start + 1;
    }
}
