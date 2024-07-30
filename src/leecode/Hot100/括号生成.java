package leecode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-30 21:35
 */
public class 括号生成 {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    static List<String> list = new ArrayList<>();

    // 输入：n = 3
    // 输出：["((()))","(()())","(())()","()(())","()()()"]
    public static List<String> generateParenthesis(int n) {
        recur("", n, n);
        return list;
    }

    /**
     * l代表剩余的左括号个数，
     * r代表剩余的右括号个数
     *
     * @description:
     * @return:
     **/
    public static void recur(String s, int l, int r) {
        if (l == 0 && r == 0) {
            list.add(s);
            return;
        }
        // 左括号没了，右括号还有，添加右括号就好了
        if (l == 0 && r > 0) {
            recur(s + ")", l, r - 1);
            return;
        }
        if (l > r) {// 此时要添加的左括号个数大于右括号，说明已经添加的左括号太少了，此时括号肯定是无效的，立即剪枝
            return;
        } else {
            recur(s + "(", l - 1, r);
            recur(s + ")", l, r - 1);
        }
    }
}
