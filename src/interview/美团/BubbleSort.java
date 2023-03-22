package interview.美团;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/16:47
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
            int[]arr={1,5,4,3,2};
            bubbleSort(arr);
            for(int i:arr){
                System.out.print(i+" ");
            }
    }
    // 1,5,4,2,3--->1,2,3,4,5
    public static void bubbleSort(int[]arr){
        int n= arr.length;
        // 控制比较趟数，n个数需要比较n-1次！
        for(int i=0;i<n-1;i++){
            // 控制每趟比较次数，第i+1躺（i从0开始）需要比较n-1-i次的。
            for(int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[]arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
