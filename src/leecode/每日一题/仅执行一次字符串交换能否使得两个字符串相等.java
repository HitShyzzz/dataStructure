package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/11/21:07
 * @Description:
 */
public class 仅执行一次字符串交换能否使得两个字符串相等 {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ac";
        boolean b = areAlmostEqual(s1, s2);
        System.out.println(b);
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        List<Integer> list = new ArrayList<>();// 存放的是两字符串元素不同的下标
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (list.size() > 1) {
                    return false;
                }
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() != 2) {
            return false;
        }
        return s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && (s1.charAt(list.get(1)) == s2.charAt(list.get(0)));
    }
}
