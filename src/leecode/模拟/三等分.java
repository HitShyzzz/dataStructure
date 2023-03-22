package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/06/19:01
 * @Description:
 */
public class 三等分 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int[] ints = threeEqualParts(arr);
        System.out.print(ints[0] + " " + ints[1]);
    }

    public static int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < n - 2; i++) {
            first = first * 2 + arr[i];
            if (i>0&&arr[i]==0&&arr[i]==arr[i-1]){
                continue;
            }
            for (int j = i + 2; j < n; j++) {
                if (j>i+2&&arr[j]==0&&arr[j]==arr[j-1]){
                    continue;
                }
                for (int l = j; l < n; l++) {
                    third = third * 2 + arr[l];
                }
                for (int k = i + 1; k < j; k++) {
                    second = second * 2 + arr[k];
                }
                if (first == second && second == third) {
                    return new int[]{i, j};
                } else {
                    second = 0;
                    third = 0;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
