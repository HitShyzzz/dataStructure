package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/30/10:48
 * @Description:
 */
public class 字母大小写全排列 {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> list = letterCasePermutation(s);
        for (String s1 : list) {
            System.out.print(s1 + " ");
        }
    }

    // s = "a1b2" --->["a1b2", "a1B2", "A1b2", "A1B2"]
    private static List<String> ans = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        return ans;
    }

    public static void dfs(char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        // 把当前index位置字母变换
        if (Character.isLetter(chars[index])) {
            chars[index] ^= 1 << 5;
            dfs(chars, index + 1);
            chars[index] ^= 1 << 5;
        }
        // 不把当前index位置字母变换
        dfs(chars, index + 1);
    }
}
