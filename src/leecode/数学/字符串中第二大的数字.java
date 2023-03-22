package leecode.数学;

import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/03/10:20
 * @Description:
 */
public class 字符串中第二大的数字 {
    public static void main(String[] args) {
        String s = "abc1111";
        int i = secondHighest(s);
        System.out.println(i);
    }

    // dfa12321afd
    public static int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                set.add((c - '0'));
            }
        }
        if (!set.isEmpty()) {
            set.remove(set.last());
        }
        return set.isEmpty() ? -1 : set.last();
    }
}
