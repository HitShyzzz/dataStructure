package leecode.recur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/17:03
 * @Description:
 */
public class 单词拆分方法2 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("lee");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    private static Map<Integer, Boolean> map = new HashMap<>();
    private static boolean flag = false;

    public static boolean wordBreak(String s, List<String> wordDict) {
        return recur(s, wordDict, 0);
    }

    /**
     * 针对最原始的递归，进行记忆化搜索，把之前算的结果利用HashMap存储起来，如果已经判断过了，就直接调用存储的结果！
     * O(T)=O(n)，每个元素只会访问一次；
     * O(S)=O(n),递归空间栈的调用最深为O(n);
     *
     * @param s        目标字符串
     * @param wordDict 单词集合
     * @param index    当前访问到wordDict中的下标
     * @return 访问到当前下标是否能匹配目标字符串！
     */
    public static boolean recur(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        Integer key = index;
        if (map.get(key) != null) {
            return map.get(key);
        }
        for (int i = index + 1; i <= s.length(); i++) {
            // 从这个条件出来的时候，已经访问到wordDict包含s的第一个单词位置的下标了，
            if (!wordDict.contains(s.substring(index, i))) {
                continue;
            }
            // 这里递归的时候已经从wordDict中包含了s的下标处继续往后走了！
            flag = recur(s, wordDict, i);
            map.put(index, flag);
        }
        // 如果已经走到s的末尾了，还是continue跳过，此时直接结束循环，返回flag的默认值false；
        return flag;
    }
}
