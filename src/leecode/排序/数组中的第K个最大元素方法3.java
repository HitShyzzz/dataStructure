package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/15:35
 * @Description:
 */
public class 数组中的第K个最大元素方法3 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    /**
     * 堆排序，手写堆排序，不利用优先级队列！
     * O(T)=O(nlogn);
     * O(S)=O(logn);主要来自递归空间栈的调用！
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 建堆完成后，开始逐个删除堆顶元素，删除k-1次，那么堆顶元素就是第k大元素
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            // 每次都把最后一个元素放到删除后的堆顶位置，然后进行大跟堆调整！
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] nums, int heapSize) {
        // 从最后一个父结点位置，开始调整大根堆,最后一个子结点的坐标是heapSize-1,那么最后一个父结点的坐标是(heapSize-1-1)/2;
        for (int i = (heapSize - 1 - 1) / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public static void maxHeapify(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
