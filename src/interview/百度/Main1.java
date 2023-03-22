package interview.百度;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/15/19:33
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextLine();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int score = 0;
            int max = 0;
            int min = Integer.MAX_VALUE;
            char[] cur = s[i].toCharArray();
            for (int j = 0; j < cur.length; j++) {
                char c = cur[j];
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Character key : map.keySet()) {
                max = Math.max(max, map.get(key));
                min = Math.min(min, map.get(key));
            }
            score = max - min;
            ans = Math.max(ans, score);
            //System.out.println(score);
        }
        System.out.println(ans);
    }
}
