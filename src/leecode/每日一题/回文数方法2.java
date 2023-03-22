package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/04/20:58
 * @Description:
 */
public class 回文数方法2 {
    // 得到整数的每一位，一位一位处理
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            int temp = x % 10;
            list.add(temp);
            x = x / 10;
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) != list.get(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
