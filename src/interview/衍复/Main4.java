package interview.衍复;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-06 22:27
 */
public class Main4 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integers = partitionLabels(s);
        System.out.println(integers);
    }

    // 输入：s = "ababcbacadefegdehijhklij"
    // 输出：[9,7,8]
    // 解释：
    // 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
    public static List<Integer> partitionLabels(String s) {
        int n = s.length();
        // 记录每个字符出现的最后一个位置
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
