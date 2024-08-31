package leecode.top50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-29 20:07
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }

    static Map<Character, String> map = new HashMap<>();
    static List<String> ans = new ArrayList<>();

    // 输入：digits = "23"
    // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public static List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        recur(digits, 0, new StringBuilder());
        return ans;
    }

    public static void recur(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String letter = map.get(digits.charAt(index));
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            recur(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
