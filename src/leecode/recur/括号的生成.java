package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/21/17:02
 * @Description:
 */
public class 括号的生成 {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        int l = n;// 初始的左括号的数量为n
        int r = n;// 初始的右括号数量也为n
        recur(l, r, new StringBuilder());
        return ans;
    }

    public static void recur(int l, int r, StringBuilder sb) {
        if (l == 0 && r == 0) {
            ans.add(sb.toString());
            return;
        }
         if (l == r) {// l==r，此时只能去添加"(";
            sb.append("(");
            recur(l - 1, r, sb);
            // 每次递归都需要回溯，
            sb.deleteCharAt(sb.length()-1);
        } else if(l<r) {// l<r，此时可以添加"("，也可以去添加")";
            if(l>0){
                sb.append("(");
                recur(l-1,r,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(")");
            recur(l,r-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
