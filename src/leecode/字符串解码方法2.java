package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/23/17:20
 * @Description:
 */
public class 字符串解码方法2 {
    public static void main(String[] args) {
        String s="3[a2[c]]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }
    // 辅助栈方法
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();// 表示结果字符串
        int multi = 0;// 表示需要重复的次数
        Deque<Integer> stack_multi = new LinkedList<>();// 重复次数栈
        Deque<String> stack_res = new LinkedList<>();// 中间字符符串栈
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(sb.toString());
                multi = 0;// 这里归0是为了下一次遇到数字重复
                sb = new StringBuilder();// 这里置空也是为了记录下一次的结果
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(stack_res.removeLast() + temp);
            } else if(Character.isDigit(c)){
                multi=multi*10+c-'0';
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
