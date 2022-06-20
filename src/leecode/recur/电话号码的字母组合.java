package leecode.recur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/20/21:21
 * @Description:
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    private static List<String> ans = new ArrayList<>();// 用于返回的结果集

    /**
     * 标准的递归回溯题目，
     * O(T)=O(3^m*4^n),m是字符串中对应字符串长度为3的个数，n是字符串中对应字符串长度为4的个数，
     * O(S)=O(m+n),空间复杂度主要来自建立数字字符串映射的HashMap和递归空间栈的调用！
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        // 首先建立数字和字母的对应关系，用HashMap
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recur(map, digits, 0, new StringBuilder());
        return ans;
    }

    /**
     * @param map    记录数字和字符的映射关系
     * @param digits 原始字符串
     * @param index  记录递归的下标
     * @param sb     中间结果的字符串，用于向结果集中添加
     */
    public static void recur(Map<Character, String> map, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String letter = map.get(digits.charAt(index));
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            recur(map, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);// 进行回溯
        }
    }
}
