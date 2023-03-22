package leecode.二分查找;

import java.util.Arrays;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/03/11:09
 * @Description:
 */
public class 数组中的逆序对 {
    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        int i = InversePairs(array);
        System.out.println(i);
    }

    /**
     * 归并排序，我们在对左边数组和右边数组进行合并时，如果nums[i]>nums[j],那么i,i+1,...,mid的元素都会大于j,
     * 那么此时产生的逆序对数就是mid-i+1;这也是算法的核心思想
     * 具体细节代码都有注释！
     * O(T)=O(nlogn);
     * O(S)=O(n);归并排序需要用到一个临时数组！
     *
     * @param array
     * @return
     */
    public static int InversePairs(int[] array) {
        int n = array.length;
        if (n < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(array, n);// 原数组的复制，避免对原来的数组值覆盖
        int[] temp = new int[n];// 记录中间结果的临时数组，用于对原数组值进行覆盖
        return reversePairs(copy, 0, n - 1, temp);
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return nums[left, right]内的子数组的逆序对的个数
     */
    public static int reversePairs(int[] nums, int left, int right, int[] temp) {
        // 递归出口
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        // nums[left,mid]的子数组的逆序对的个数
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {// 此时左边数组的最大值小于右边数组的最小值，那么合并的时候不会产生逆序对，
            return leftPairs + rightPairs;
        }
        // 合并左右数组产生的逆序对数
        int crossPairs = merge(nums, left, mid, right, temp);
        // 总的逆序对数=左子数组的逆序对数+右子数组的逆序对数+合并时新产生的逆序对数
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return 合并左右子数组时新产生的逆序对数
     */
    public static int merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;// 左边子数组的左边界
        int j = mid + 1;// 右边子数组的左边界
        int count = 0;// 记录合并时产生的逆序对数
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {// 此时左边数组是没有元素的
                nums[k] = temp[j++];
            } else if (j == right + 1) {// 此时右边数组是没有元素的
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {// temp[i]>temp[j],那么从i,i+1,...mid的元素都是大于temp[j]的，此时产生的逆序对数就是mid-i+1;
                nums[k] = temp[j++];// 右边的数更小，先合并右边的
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
