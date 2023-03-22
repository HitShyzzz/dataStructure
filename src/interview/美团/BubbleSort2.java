package interview.美团;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/18:58
 * @Description:
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 1,5,4,2,3--->1,2,3,4,5
    // 冒泡排序继续优化，如果数组是部分有序的，有序的部分就不要比了！
    // 冒泡排序是稳定排序，因为不涉及两个相等的数交换的情况，时间复杂度是O(n^2);
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int boundUnSort = n - 1;// 无序序列的边界
        int lastSwapIndex = 0;// 记录最后一次交换的位置！
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < boundUnSort; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                    lastSwapIndex = j;
                }
            }
            boundUnSort = lastSwapIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
