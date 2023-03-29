package interview.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/19:53
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            list.add(n - k + i);
            list.add(i);
        }
        int last = k + 1;
        while (list.size() < n) {
            list.add(last);
            last++;
        }
        while (list.size() > n) {
            list.remove(list.size() - 1);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


}
