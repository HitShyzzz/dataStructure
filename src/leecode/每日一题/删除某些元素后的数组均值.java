package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/14/10:07
 * @Description:
 */
public class 删除某些元素后的数组均值 {
    public static void main(String[] args) {
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        double v = trimMean(arr);
        System.out.println(v);
    }

    public static double trimMean(int[] arr) {
        int n = arr.length;
        int delete = (int) (n * 0.05);
        Arrays.sort(arr);
        int sum = 0;
        for (int i = delete; i < n - delete; i++) {
            sum += arr[i];
        }
        return sum / (0.9 * n);
    }
}
