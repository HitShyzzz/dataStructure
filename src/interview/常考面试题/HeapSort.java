package interview.常考面试题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/17:49
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 7, 11, 5, 12, 3, 0, 1};
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序前：" + Arrays.toString(arr));
    }

    /**
     * 堆排序，构建大根堆，O(T)=O(nlogn),O(S)=O(nlogn),不稳定排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        // 先第一个非叶子结点，从下向上，自右向左构建大根堆
        for (int j = arr.length / 2 - 1; j >= 0; j--) {
            adjustHeap(arr, j, arr.length);
        }
        // 把堆顶元素和最后一个元素进行交换，并且调整堆结构
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int len) {
        int tmp = arr[i];// 先把根结点元素取出来
        // 从叶子结点开始调整
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 左子结点<右子节点,k就指向右子节点
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            // 子节点比父节点大
            if (arr[k] > tmp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = tmp;// 把根结点放到应该放的位置上
    }
}
