package interview.携程;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/19:21
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 0;
        int y = 0;
        long num = 0;
        long min = Integer.MAX_VALUE;
        List<Long> list = new ArrayList<>();
        list.add(1l);
        for (int i = 1; i <= n; i++) {
            long a = i;
            a = a * list.get(list.size() - 1);
            list.add(a);
            for (int j = 1; j <= n; j++) {
                num = Math.abs(a * j - j - n);
                if (num < min && (i != 2) && (j != 2)) {
                    min = num;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.print(x + " " + y);
    }
}
