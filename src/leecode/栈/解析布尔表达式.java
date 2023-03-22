package leecode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/05/10:04
 * @Description:
 */
public class 解析布尔表达式 {
    // expression="|(&(t,f,t),|(t))"
    public boolean parseBoolExpr(String expression) {
        Deque<Character>stack=new ArrayDeque<>();
        for(int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            }
            if (c == ')') {
                int t = 0;
                int f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else if (val == 'f') {
                        f++;
                    }
                }
                stack.pop();// pop的是'('
                char on = stack.pop(); // pop的是运算符
                switch (on) {
                    case '!':
                        if (f == 1) {
                            stack.push('t');
                        } else {
                            stack.push('f');
                        }
                        break;
                    case '&':
                        if (f == 0) {
                            stack.push('t');
                        } else {
                            stack.push('f');
                        }
                        break;
                    case '|':
                        if (t > 0) {
                            stack.push('t');
                        } else {
                            stack.push('f');
                        }
                        break;
                    default:
                }
            }
        }
            return stack.peek() == 't';
    }
}
