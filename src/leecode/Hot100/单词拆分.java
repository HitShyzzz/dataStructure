package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-19 21:04
 */
public class 单词拆分 {
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        // List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    // 输出: false
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean ans = dfs(s, set);
        return ans;
    }

    // 递归记忆化搜索，
    // O(T)=O(N*K)
    // O(S)=O(N*K)
    public static boolean dfs(String s, Set<String> set) {
        if (s == null || s.length() == 0) return true;
        if (map.get(s) != null) return map.get(s);
        boolean ans = false;
        for (int i = 0; i <= s.length(); i++) {
            // 如果包含了s(0,i)，就去判断s(i,n)是否包含
            if (set.contains(s.substring(0, i))) {
                ans = dfs(s.substring(i), set) || ans;
                map.put(s, ans);
            }
        }
        return ans;
    }
}
