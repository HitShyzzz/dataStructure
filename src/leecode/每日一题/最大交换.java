package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/8:57
 * @Description:
 */
public class 最大交换 {
    public static void main(String[] args) {
        int num = 9937;
        int i = maximumSwap(num);
        System.out.println(i);
    }

    // 2736---》7632---》交换2和7---》7236.
    public static int maximumSwap(int num) {
        char[] original = String.valueOf(num).toCharArray();
        char[] temp = String.valueOf(num).toCharArray();
        int n = original.length;
        Arrays.sort(temp);// 从小到大排列，我们的目标是从大到小，因此我们要逆序遍历temp数组
        Character first = null;// 第一个交换的元素
        Character second = null;// 第二个交换的元素
        for (int i = 0; i < n; i++) {
            if (original[i] != temp[n - 1 - i]) {
                first = original[i];
                second = temp[n - 1 - i];
                original[i] = temp[n - 1 - i];// 第一个位置替换为新的元素
                break;
            }
        }
        if (second != null) {
            for (int i = n - 1; i >= 0; i--) {
                if (original[i] == second) {
                    original[i] = first;// 第二个位置替换为第一个元素
                    break;
                }
            }
        }
        return Integer.parseInt(new String(original));
    }
}
