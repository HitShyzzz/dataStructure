package leecode.数学;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/14/10:41
 * @Description:
 */
public class 数组的均值分割 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        boolean b = splitArraySameAverage(nums);
        System.out.println(b);
    }

    public static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        // 分成均值相等的两个部分，那么这个均值一定是等于原来数组的均值的，因此我们可以把原数组a[i]-avg，这样新的数组
        // 之和就是0；我们现在要找的就是俩个数组使得这两个数组之和都为0！

        // 先求所有数组的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 再把数组a[i]-avg等价于n*a[i]-sum，这样新的数组相加也是0
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * n - sum;
        }
        // 把数组分成两个部分，每个部分n/2个元素
        int m = n / 2;
        // 对于每个元素都可以选和不选，共有2^m种选法
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                // 对于每一个状态i,a[0],...a[m-1]都可以选和不选，
                if ((i & (1 << j)) != 0) {
                    total += nums[j];
                }
            }
            // 如果直接就找到了0，就返回true！
            if (total == 0) {
                return true;
            }
            set.add(total);
        }
        // rnum表示的是右边剩下元素全选，这样一来集合B就是空的了，
        int rnum = 0;
        for (int i = m; i < n; i++) {
            rnum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int total = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    total += nums[j];
                }
            }
            // total!=rnum保证的是集合B不为空，或者右边集合出现了-total，那么相加就是0，就找到了答案!
            if (total == 0 || (total != rnum && set.contains(-total))) {
                return true;
            }
        }
        return false;
    }
}
