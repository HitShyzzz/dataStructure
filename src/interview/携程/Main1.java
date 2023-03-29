package interview.携程;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/19:05
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 1);
        map.put('6', 1);
        map.put('9', 1);
        map.put('8', 2);
        String s = in.nextLine();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                res += map.get(c);
            }
        }
        System.out.println(res);
    }
}
