package interview.京东;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/18:39
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        long l = CountOfGoodString(s);
        System.out.println(l);
        long l1 = jieCheng(10);
        long l2 = function(10, 2);
        System.out.println(l1);
        System.out.println(l2);

    }

    public static long CountOfGoodString(String s) {
        int n = s.length();
        long res = 0;
        if (n % 3 != 0) {
            return 0;
        }
        // 去统计每个字符的数量
        Map<Character, Integer> map = new HashMap<>();
        map.put('r', 0);
        map.put('e', 0);
        map.put('d', 0);
        map.put('?', 0);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.get('?') == 0) {
            if (map.get('r').equals(map.get('e')) && map.get('e').equals(map.get('d'))) {
                return n / 3;
            } else {
                return 0;
            }
        } else {
            int d = map.get('?');
            int a = map.get('r');
            int b = map.get('e');
            int c = map.get('d');
            int max = Math.max(a, Math.max(b, c));
            if (max == a) {
                if (max - b + max - c != d) {
                    return 0;
                } else {// res=A(d,max-b)*A(max-c.max-c)
                    res = function(d, max - b) * function(max - c, max - c);
                }
            } else if (max == b) {
                if (max - a + max - c != d) {
                    return 0;
                } else {
                    res = function(d, max - a) * function(max - c, max - c);
                }
            } else {// max==c
                if (max - a + max - b != d) {
                    return 0;
                } else {
                    res = function(d, max - a) * function(max - b, max - b);
                }
            }
        }
        return res;
    }
    // 计算排列数

    /**
     * @param n
     * @param k
     * @return A(n, k)的值
     */
    public static long function(int n, int k) {
        return jieCheng(n) / jieCheng(n - k);
    }

    // 计算阶乘
    public static long jieCheng(int n) {
        // 0的阶乘是1
        if (n == 0) {
            return 1;
        }
        long prod = 1;
        for (int i = 1; i <= n; i++) {
            prod = prod * i;
        }
        return prod;
    }
}
