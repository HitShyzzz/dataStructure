package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/07/9:55
 * @Description:
 */
public class 模糊字符串 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        // 先把开头的'('和结尾的')'去掉只剩下数字
        String s1 = s.substring(1, n - 1);
        for (int i = 1; i < n - 2; i++) {
            List<String> part1 = addDecimal(s1.substring(0, i));
            List<String> part2 = addDecimal(s1.substring(i));
            for (String p1 : part1) {
                for (String p2 : part2) {
                    ans.add("(" + p1 + ", " + p2 + ")");
                }
            }
        }
        return ans;
    }

    // 给字符串s的每一位后面添加小数点'.'
    public List<String> addDecimal(String s) {
        List<String> list = new ArrayList<>();
        // s自己是符合题意的，就先把自己加进去！
        if (s.length() == 1 || s.charAt(0) != '0') {
            list.add(s);
        }
        // 给字符串的每一位依次去添加小数点
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            // s1开头不能是0，s2结尾不能是0
            if ((s1.length() == 1 || s1.charAt(0) != '0') && (s2.charAt(s2.length() - 1) != '0')) {
                list.add(s1 + "." + s2);
            }
        }
        return list;
    }
}
