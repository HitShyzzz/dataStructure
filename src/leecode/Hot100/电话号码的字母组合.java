package leecode.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-02 10:16
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    static Map<Character, String> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return list;
        // 先维护数字和字母的对应关系
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recur(digits, 0, new StringBuilder());
        return list;
    }

    public static void recur(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letter = map.get(digits.charAt(index));
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            recur(digits, index + 1, sb);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
