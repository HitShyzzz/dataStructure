package leecode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/20/8:52
 * @Description:
 */
public class 单词拆分 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, wordDict);
    }

    /**
     * @param s
     * @param start
     * @param wordDict
     * @return s[start, len]的子串能否拆解出wordDict里的单词，暴力搜索会超时，尝试记忆化递归
     */
    public static boolean dfs(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if (wordDict.contains(prefix) && dfs(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }
}
