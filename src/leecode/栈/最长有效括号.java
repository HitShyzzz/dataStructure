package leecode.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/22/19:29
 * @Description:
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        String s="(()";
        int longestValidParentheses = longestValidParentheses(s);
        System.out.println(longestValidParentheses);
    }
    /**
     * 栈，栈底放的是最后一个未被匹配的‘）’的下标，其他位置放‘（’的下标；
     *O(T)=O(n),只需要遍历1次字符串
     *O(S)=O(n),最坏情况下全是'('，全部入栈，因此O(S)=O(n);
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int ans=0;
        int n=s.length();
        Deque<Integer>stack=new LinkedList<>();
        // 这一步真是诀绝子！加-1是为了防止上来就是‘（’，那么此时就要入栈了，就不符合我们的约定栈底放最后一个未被匹配的‘）’的下标
        stack.push(-1);
        char[]c=s.toCharArray();
        for(int i=0;i<n;i++){
            // ‘（’就要入栈
            if(c[i]=='('){
                stack.push(i);
            }else{// c[i]是')'
                stack.pop();
                // 栈为空，那么当前右括号就是我们要找的最后一个未被匹配的‘）’，入栈
                if(stack.isEmpty()){
                    stack.push(i);
                }else{// 栈不空，那么当前右括号是可以匹配的，同时更新答案
                    ans=Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }
}
