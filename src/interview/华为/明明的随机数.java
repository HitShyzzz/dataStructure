package interview.华为;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 18:22
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (in.hasNext()) {
            int N = in.nextInt();
            for (int i = 0; i < N; i++) {
                int e = in.nextInt();
                set.add(e);
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
    }
}
