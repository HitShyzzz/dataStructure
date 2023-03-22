package interview.中国系统;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/30/15:51
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();// s = "III"
        String s1 = s.substring(5, s.length() - 1);// III
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] c = s1.toCharArray();
        int ans = 0;
        for (int i = 0; i < c.length; i++) {
            int temp = map.get(c[i]);
            if (i + 1 < c.length) {
                // 小的在大的左边
                if (map.get(c[i]) < map.get(c[i + 1])) {
                    temp = -1 * temp;
                }
            }
            ans += temp;
        }
        System.out.println(ans);
    }
}
