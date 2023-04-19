package solution;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/14/18:45
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) {
        String s = "cba";
        int i = s.indexOf(s);
        System.out.println(i);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String str = String.valueOf(c);
        System.out.println(str);
        System.out.println("销毁！");
        Date date = new Date();
        System.out.println(new Date());
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num, 0, nums1.length);
        System.arraycopy(nums2, 0, num, nums1.length, nums2.length);
        Arrays.sort(num);
        int n = num.length;
        if (n % 2 != 0) {
            return num[n / 2] * 1.0;
        } else {
            return (num[n / 2] + num[n / 2 - 1]) / 2.0;
        }
    }
}
