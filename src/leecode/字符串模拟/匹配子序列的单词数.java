package leecode.字符串模拟;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/17/9:49
 * @Description:
 */
public class 匹配子序列的单词数 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int i = numMatchingSubseq(s, words);
        System.out.println(i);
    }

    // s = "abcde", words = ["a","bb","acd","ace"]---》3
    public static int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (isSubseq(word, s)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @param s 字符串s
     * @param t 字符串t
     * @return 字符串s是否是t的子序列
     */
    public static boolean isSubseq(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
