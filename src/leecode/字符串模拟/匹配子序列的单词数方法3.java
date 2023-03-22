package leecode.字符串模拟;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/17/9:49
 * @Description:
 */
public class 匹配子序列的单词数方法3 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int i = numMatchingSubseq(s, words);
        System.out.println(i);
    }

    // s = "abcde", words = ["a","bb","acd","ace"]---》3
    // 对于每一个s的字符，同时去匹配所有的words字符串数组
    public static int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Queue<int[]> queue[] = new Queue[26];
        // 把queue[i]实例化
        for (int i = 0; i < 26; i++) {
            queue[i] = new ArrayDeque<>();
        }
        // 把字符串数组words按照首字母进行分类
        for (int i = 0; i < words.length; i++) {
            queue[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        // 一一遍历字符串s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 以字符c开头的字符串word个数
            int size = queue[c - 'a'].size();
            while (size > 0) {
                int[] t = queue[c - 'a'].poll();
                // 如果第2个指针t[1]走到了words[i]单词的末尾，就匹配成功了
                if (t[1] == words[t[0]].length() - 1) {
                    ans++;
                } else {
                    t[1]++;// t[1]指针右移
                    // 同时把下一个要匹配的字符加入到队列中，这句话是关键，建议debug一下就明白了
                    queue[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                size--;
            }
        }
        return ans;
    }
}
