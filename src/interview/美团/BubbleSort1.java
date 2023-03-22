package interview.美团;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/18:54
 * @Description:
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 1,5,4,2,3--->1,2,3,4,5
    // 冒泡排序优化，如果经过前面几轮排序已经有序了，就没必要再比较了；
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                }
            }
            // 如果这趟比较完都没发生交换，说明都已经有序了，直接不比了，跳出循环！
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
