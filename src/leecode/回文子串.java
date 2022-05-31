package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/09/10:32
 * @Description:
 */
public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaa";
        int count = countSubstrings(s);
        System.out.println(count);
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (check(s.substring(j, i+1))) {
                    count++;
                }
            }
        }
        return count;
    }

    // 检查是否是回文子串
    public static boolean check(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        return s1.equals(s);
    }
}
