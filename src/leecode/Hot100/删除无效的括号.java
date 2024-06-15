package leecode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 15:59
 */
public class 删除无效的括号 {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;// 表示原字符串中多余的左括号
        int rRemove = 0;// 表示原字符串中多余的右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') lRemove++;
            if (s.charAt(i) == ')') {
                if (lRemove == 0) rRemove++;
                else lRemove--;
            }
        }
        dfs(s, 0, lRemove, rRemove);
        return ans;
    }

    /**
     * lRemove表示要移除的多余左括号数量
     * rRemove表示要移除的多余右括号数量
     * 移除多余的左括号和右括号，判断剩余字符串是否有效，如果有效，就加入结果集
     *
     * @description:
     * @return:
     **/
    public void dfs(String s, int index, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        if (lRemove + rRemove > s.length()) return;
        for (int i = index; i < s.length(); i++) {
            if (i > index && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(') dfs(s.substring(0, i) + s.substring(i + 1), i, lRemove - 1, rRemove);
            if (s.charAt(i) == ')') dfs(s.substring(0, i) + s.substring(i + 1), i, lRemove, rRemove - 1);
        }
    }

    public boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')') {
                cnt--;
                // 此时右括号多了，无法配对
                if (cnt < 0) return false;
            }
        }
        return cnt == 0;
    }
}
