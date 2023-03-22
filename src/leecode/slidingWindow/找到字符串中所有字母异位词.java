package leecode.slidingWindow;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/20:24
 * @Description:
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s="abab";
        String p="ab";
        boolean check = check("acb", "abc");
        System.out.println(check);
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
    /**
     * 异位词重新排序后必然是相同的，列举s的所有异位词子串，然后把子串的起始下标加到结果集中！
     * 这个思路虽然很简单，但显示时间复杂度是非常高的，会超时！
     *
     * @param s
     * @param p
     * @return s中所有p的异位词
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        for (int i = 0; i <=s.length() - p.length(); i++) {
            int j=i+p.length();
            if (check(s.substring(i, j), p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 异位词：所含字符要完全相同，而且字符个数也要相同
     *
     * @param s
     * @param p
     * @return s和p是否是异位词
     */
    public static boolean check(String s, String p) {
        char[]s1=s.toCharArray();
        char[]p1=p.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(p1);
        return Arrays.equals(s1, p1);
    }
}
