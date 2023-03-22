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
public class 移动所有球到每个盒子所需要的最小操作 {
    // boxes = "001011"
    // 输出：[11,8,5,4,3,4]
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        // 先去存储所有1的下标
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            char c = boxes.charAt(i);
            if (c == '1') {
                list.add(i);
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for (Integer j : list) {
                sum += Math.abs(i - j);
            }
            ans[i] = sum;
        }
        return ans;
    }
}
