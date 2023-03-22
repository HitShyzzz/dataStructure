package interview.中国系统;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/30/14:29
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String ss = s.substring(15, s.length() - 2);
        String s1 = in.nextLine();
        String ss1 = s1.substring(8, s1.length() - 1);
        String s2 = in.nextLine();
        String ss2 = s2.substring(8, s2.length() - 1);
        String[] str1 = ss.split(" ");
        int[] nums = new int[str1.length];
        for (int i = 0; i < str1.length - 1; i++) {
            nums[i] = Integer.parseInt(str1[i].substring(0, str1[i].length()-1));
        }
       nums[nums.length - 1] = Integer.parseInt(str1[str1.length - 1]);
        int m = Integer.parseInt(ss1);
        int n = Integer.parseInt(ss2);
        int[] copy = Arrays.copyOfRange(nums, m, n + 1);
        Arrays.sort(copy);
        for (int i = 0; i < m; i++) {
            System.out.println(nums[i]);
        }
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }
        for (int i = n + 1; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
