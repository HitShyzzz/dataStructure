package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/02/9:50
 * @Description:
 */
public class 移动所有球到每个盒子所需要的最小操作方法2 {
    // boxes = "001011"
    // 输出：[11,8,5,4,3,4]
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        // left表示在当前下标左侧及当前下标的小球数
        int left = boxes.charAt(0) - '0';
        // right表示当前下标右侧的小球数
        int right = 0;
        // 表示把所有球移动到当前下标所需要的操作数
        int operations = 0;
        // 先去得到初始的right
        for (int i = 1; i < n; i++) {
            char c = boxes.charAt(i);
            if (c == '1') {
                right++;
                operations += i;
            }
        }
        ans[0] = left;
        // operations[i+1]=operations[i]+left[i]-right[i];
        // 因为每往右边走1步的话，原来的left[i]都要多走1步，同时原来的right[i]也少走一步
        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                // left[i]多走1步
                left++;
                // right[i]少走1步
                right--;
            }
            ans[i] = operations;
        }
        return ans;
    }
}
