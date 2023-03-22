package leecode.recur;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/16:10
 * @Description:
 */
public class 单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        return recur(s, wordDict, 0);
    }

    /**
     * 递归地去访问s中的字符，如果访问到index，wordDict包含了这个子串，那么就递归的从index往后走，
     * 如果能走到s的末尾，说明wordDict的元素可以拼接成s,就直接return true，
     * 但这样做会进行大量重复计算导致时间复杂度过高，会超时！
     * 重复计算是在s重复使用wordDict的子串，那么前面的子串刚遍历完，现在还要再访问一次，再去判断一次；
     * 知道了重复计算在哪里发生的，就可以优化了！
     * @param s        目标字符串
     * @param wordDict 单词集合
     * @param index    当前访问到wordDict中的下标
     * @return 访问到当前下标是否能匹配目标字符串！
     */
    public static boolean recur(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            // 从这个条件出来的时候，已经访问到wordDict包含s的第一个单词位置的下标了，
            if (!wordDict.contains(s.substring(index, i))) {
                continue;
            }
            // 这里递归的时候已经从wordDict中包含了s的下标处继续往后走了！
            if (recur(s,wordDict,i)) {
                return true;
            }
        }
        return false;
    }
}
