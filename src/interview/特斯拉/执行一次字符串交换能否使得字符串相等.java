package interview.特斯拉;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/22/21:14
 * @Description:
 */
public class 执行一次字符串交换能否使得字符串相等 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        // 记录对应位置不相等的元素下标
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
                if (list.size() > 2) {
                    return false;
                }
            }
        }
        // 没有不同的
        if (list.isEmpty()) {
            return true;
        }
        // 只有一个位置不同
        if (list.size() == 1) {
            return false;
        }
        int i = list.get(0);
        int j = list.get(1);
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
