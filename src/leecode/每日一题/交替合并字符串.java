package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/23/9:46
 * @Description:
 */
public class 交替合并字符串 {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());
        int m = Math.max(word1.length(), word2.length());
        for (int i = 0; i < n; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        sb.append(word1.length() == n ? word2.substring(n, m) : word1.substring(n, m));
        return sb.toString();
    }
}
