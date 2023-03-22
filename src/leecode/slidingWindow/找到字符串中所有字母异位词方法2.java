package leecode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/21:14
 * @Description:
 */
public class 找到字符串中所有字母异位词方法2 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    /**
     * 滑动窗口，先往窗口里加s的字符直到==p.length();
     * 窗口内的字符以及他们的个数达到需要的之后，就要移动左指针来找到异位词的起始指针！
     * O(T)=O(n+m+Σ)，n是s的长度，m是p的长度，Σ是p中不同字符的个数，最坏情况下是26，首先需要O(m)来统计P中字符以及个数，
     * 然后需要O(n)遍历s的每个字符，然后对于每个窗口，我们还需要O(Σ)来找出异位词下标的起始下标；
     * O(S)=O(Σ)，Σ是p中不同字符的个数，最坏情况下是26。
     *
     * @param s
     * @param p
     * @return s中p的所有异位词子串的起始下标！
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char p1 : p.toCharArray()) {
            need.put(p1, need.getOrDefault(p1, 0) + 1);
        }
        int left = 0;// 窗口的左边界
        int right = 0;// 窗口的有边界
        int valid = 0;// 窗口内的有效字符个数
        while (right < s.length()) {
            if (need.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)) <= need.get(s.charAt(right))) {
                    valid++;
                }
            }
            // 这里用了循环，是因为前面可能会有need不需要的字符出现，如s=abccc,p=ccc;那么left指针就需要一直移动，
            // 直到达到need需要的第一个字符c出现！
            while (valid == p.length()) {
                // left指针移动到need需要的第一个字符了。就加入到结果集！
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                if (need.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    // 很可能出现s=aabba,p=ab;这时遇到的第一个a其实并不是我们想要的，原因就是a多了！
                    if (window.get(s.charAt(left)) < need.get(s.charAt(left))) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
