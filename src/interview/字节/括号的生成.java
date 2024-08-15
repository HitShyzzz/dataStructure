package interview.字节;


import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-16 0:02
 */
public class 括号的生成 {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(1);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        recur(n, n, new StringBuilder());
        return list;
    }

    public static void recur(int l, int r, StringBuilder sb) {
        if (l == 0 && r == 0) {
            list.add(sb.toString());
            return;
        }
        if (l == r) {
            sb.append('(');
            recur(l - 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (l < r) {// 此时"("和")"都可以添加
            if (l > 0) {
                sb.append('(');
                recur(l - 1, r, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            recur(l, r - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
