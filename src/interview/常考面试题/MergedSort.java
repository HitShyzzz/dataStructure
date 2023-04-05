package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/17:20
 * @Description:
 */
public class MergedSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        mergeSort(arr, 0, arr.length - 1, tmp);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 合并两个有序数组
    public static void merge(int[] nums, int l, int mid, int r, int[] tmp) {
        int i = 0;
        int j = l;// 左边数组起始索引
        int k = mid + 1;// 右边数组起始索引
        while (j <= mid && k <= r) {
            if (nums[j] <= nums[k]) {
                tmp[i++] = nums[j++];
            } else {
                tmp[i++] = nums[k++];
            }
        }
        // 把左边没合并完的拿过来
        while (j <= mid) {
            tmp[i++] = nums[j++];
        }
        // 把右边没合并完的拿过来
        while (k <= r) {
            tmp[i++] = nums[k++];
        }
        // 把排好序的tmp替换掉arr
        for (int t = 0; t < i; t++) {
            nums[l + t] = tmp[t];
        }
    }

    /**
     * 归并排序，O(T)=O(nlogn),O(S)=O(nlogn) 稳定的排序算法
     * @param nums
     * @param l
     * @param r
     * @param tmp
     */
    // 归并排序
    public static void mergeSort(int[] nums, int l, int r, int[] tmp) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid, tmp);
            mergeSort(nums, mid + 1, r, tmp);
            merge(nums, l, mid, r, tmp);
        }
    }


}
