package interview.海康卫视;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/26/10:22
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";
        int contains = contains(j, s);
        int contains1 = contains1(j, s);
        System.out.println(contains);
        System.out.println(contains1);
    }

    public static int contains(String j, String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (j.indexOf(c) != -1) {
                ans++;
            }
        }
        return ans;
    }

    public static int contains1(String J, String s) {
        int m = J.length();
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char c1 = J.charAt(i);
            for (int j = 0; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
