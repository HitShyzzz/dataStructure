package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/11/9:49
 * @Description:
 */
public class 判断字符串的两半是否相似 {
    // s = "book" a="bo" b="ok"---->元音字母个数都是1，---》true
    public boolean halvesAreAlike(String s) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < a.length(); i++) {
            if (list.contains(a.charAt(i))) {
                countA++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (list.contains(b.charAt(i))) {
                countB++;
            }
        }
        return countA == countB;
    }
}
