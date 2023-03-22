package interview.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/20/10:15
 * @Description:
 */
public class 调整数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(nums);
        int minOperation = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += (Math.abs(nums[i] - (i - j) - nums[j]));
            }
            for(int j=i+1;j<n;j++){
                count+=Math.abs(nums[i]+(j-i)-nums[j]);
            }
          //  System.out.println(count);
            minOperation = Math.min(minOperation, count);
        }
        System.out.println(minOperation);
    }
}
