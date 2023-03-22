package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/9:31
 * @Description:
 */
public class 有效的字母异位词 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        for (int i = 0; i < n; i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }
}
