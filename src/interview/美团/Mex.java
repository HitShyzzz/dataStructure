package interview.美团;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/19/21:33
 * @Description:
 */
public class Mex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            list.add(nums[i]);
        }
        // int[] copy = Arrays.copyOf(nums, n);
        // 我们的目标是找最大值，我们可以先遍历一遍，找到最大值，没必要排序
        // Arrays.sort(copy);
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int mex = -1;
        for (int i = 0; i <= nums[n - 1]; i++) {
            if (!list.contains(i)) {
                mex = i;
                break;
            }
        }
        if (mex == -1) {
            mex = nums[n - 1] + 1;
        }
        System.out.println(mex);
        for (int i = 0; i < n; i++) {
            if (nums[i] < mex) {
                System.out.print(nums[i] + " ");
            } else {
                System.out.print(mex + " ");
            }
        }
    }
}
