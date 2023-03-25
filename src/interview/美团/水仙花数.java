package interview.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/17:01
 * @Description:
 */
public class 水仙花数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = m; i <= n; i++) {
                if (check(i)) {
                    list.add(i);
                }
            }
            if (list.size() == 0) {
                System.out.println("no");
            } else {
                for (Integer key : list) {
                    System.out.print(key + " ");
                }
            }
        }
        in.close();
    }

    // 判断n是否是水仙花数
    public static boolean check(int n) {
        int sum = 0;
        int cur = n;
        while (cur != 0) {
            int a = (cur % 10);
            sum += (a * a * a);
            cur = cur / 10;
        }
        return sum == n;
    }
}
