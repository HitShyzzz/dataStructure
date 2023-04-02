package leecode.剑指offer突击版;

import java.util.HashSet;
import java.util.IllegalFormatCodePointException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/11:05
 * @Description:
 */
public class 最大的异或 {
    // 输入：nums = [3,10,5,25,2,8]
    // 输出：28
    // 解释：最大运算结果是 5 XOR 25 = 28.
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maximumXOR = findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }

    /**
     * 我们从最高位开始一一去枚举每一位数字，要想异或结果最大，就看每一位是否能取得到1
     *
     * @param nums
     * @return
     */
    public static int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 依次把num的最高k位加到set中
                set.add(num >> k);
            }
            // 我们想要的第k位是1
            int xNext = x * 2 + 1;
            // 标记能否找到第k位是1；
            boolean flag = false;
            for (int num : nums) {
                // x=aiXORaj，那么aj=xXORai;
                if (set.contains(xNext ^ (num >> k))) {
                    flag = true;
                    break;
                }
            }
            // 能找到
            if (flag) {
                x = xNext;
            } else {// 找不到，那么第k位就只能为0；
                x = xNext - 1;
            }
        }
        return x;
    }
}
