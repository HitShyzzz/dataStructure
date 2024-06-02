package interview.华为;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 18:25
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 10);
        map.put('D', 10);
        map.put('E', 10);
        map.put('F', 10);
        while (in.hasNext()) {
            String s = in.next().substring(2);
            char[] c = s.toCharArray();
            int change = 0;
            int ans = 0;
            for (int i = c.length - 1; i >= 0; i--) {
                if (Character.isLetter(c[i])) {
                    ans += (int) (map.get(c[i]) * Math.pow(16, change++));
                } else {
                    ans += (int) ((c[i] - '0') * Math.pow(16, change++));
                }
            }
            System.out.println(ans);
        }
    }
}
