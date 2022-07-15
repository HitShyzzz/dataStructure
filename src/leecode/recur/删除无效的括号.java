package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/15/20:39
 * @Description:
 */
public class 删除无效的括号 {
    private List<String> ans = new ArrayList<>();

    /**
     * 回溯剪枝，先计算出最少需要去掉的"("和")",然后递归的去删除"("和“)”,如果删除之后字符串有效，
     * 就把当前字符串加入到结果集中！
     * 这里有一些可以剪枝优化的地方，细节都给了注释！
     * O(T)=O(n*2^n);s总共有2^n个子序列，每个子序列可能都需要一次合法性检查，因此总的时间复杂度是O(n*2^n);
     * O(S)=O(n^2);
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int lRemove = 0;// 要删除的最少左括号数
        int rRemove = 0;// 要删除的最少右括号数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                lRemove++;
            }
            if (s.charAt(i) == ')') {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        recur(s, 0, lRemove, rRemove);
        return ans;
    }

    public void recur(String s, int index, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        // 如果要删除的总长度比当前剩下的字符串长度还要长，那就可以结束了！
        if (lRemove + rRemove > s.length()) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // 如果是连续相同的左括号或者右括号，只删除一次就行了，后面相同的可以跳过了！
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 试着删除左括号
            if (lRemove > 0 && s.charAt(i) == '(') {
                recur(s.substring(0, i) + s.substring(i + 1), i, lRemove - 1, rRemove);
            }
            // 试着删除右括号
            if (rRemove > 0 && s.charAt(i) == ')') {
                recur(s.substring(0, i) + s.substring(i + 1), i, lRemove, rRemove - 1);
            }

        }

    }

    /**
     * 判断字符串s中的括号是否有效
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        int cnt = 0;// 记录多余的左括号数目
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            if (s.charAt(i) == ')') {
                cnt--;
                // 此时左括号数目会多于右括号的数目，当前的右括号是没人配对的！
                if (cnt < 0) {
                    return false;
                }
            }
        }
        // cnt==0,说明所有的左括号和右括号都有人配对了，就可以返回true了。
        return cnt == 0;
    }
}
