package interview.tencent;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-12 21:09
 */
public class Main {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(get(s));
    }


    public static String get(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (i < n) {
            char c = s.charAt(i);
            while (i < n && s.charAt(i) == c) {
                i++;
                cnt++;
            }
            sb.append("" + c + cnt);
            cnt = 0;
        }
        return sb.toString();
    }
}
