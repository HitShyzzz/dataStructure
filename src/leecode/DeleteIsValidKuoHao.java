package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: shy
 * @Date: 2022/04/16/10:23
 * @Description:
 */
public class DeleteIsValidKuoHao {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;// 需要去除的左括号
        int rremove = 0;// 需要去除的右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            }
            if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        recur(s, 0, lremove, rremove);
        return ans;
    }

    public void recur(String s, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 连续相同字符只需要去掉一个就行，效果是一样的。
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 需要去掉的字符数量超过了剩下的字符数，就停下来。
            if (rremove + lremove > s.length() - i) {
                return;
            }
            // 去掉左括号
            if (lremove > 0) {
                recur(s.substring(0, i) + s.substring(i + 1), i, lremove - 1, rremove);
            }
            // 去掉右括号
            if (rremove > 0) {
                recur(s.substring(0, i) + s.substring(i + 1), i, lremove, rremove - 1);
            }
        }

    }

    public boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
