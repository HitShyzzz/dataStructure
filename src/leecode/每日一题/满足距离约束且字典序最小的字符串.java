package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-27 12:24
 */
public class 满足距离约束且字典序最小的字符串 {
    public static void main(String[] args) {
        String s = "lol";
        int k = 0;
        String smallestString = getSmallestString(s, k);
        System.out.println(smallestString);
        System.out.println(Math.min('x' - 'a', 26 - ('x' - 'a')));
    }

    // "xaxcd" k=4
    public static String getSmallestString(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                sb.append(c);
                continue;
            }
            int dis = Math.min(c - 'a', 26 - (c - 'a'));
            if (k > 0 && dis <= k) {
                sb.append('a');
                k -= dis;
            } else if (dis > k) {
                char prev = (char) (c - k);
                k = 0;
                sb.append(prev);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
