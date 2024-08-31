package leecode.top50;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 遇到左括号就入栈，右括号就出栈
 * @date: 2024-08-29 21:13
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String s = "[";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    // 输入：s = "()[]{}"
    //
    // 输出：true
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || '(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (map.containsKey(c) && map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
