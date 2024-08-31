package leecode.top50;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 8:23
 */
public class 括号生成 {
    List<String> list = new ArrayList<>();

    // 输入：n = 3
    // 输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        recur(n, n, new StringBuilder());
        return list;
    }

    public void recur(int l, int r, StringBuilder sb) {
        if (l == 0 && r == 0) {
            list.add(sb.toString());
            return;
        }
        if (l < r) {
            if (l > 0) {
                sb.append('(');
                recur(l - 1, r, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            recur(l, r - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (l == r) {
            sb.append('(');
            recur(l - 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
