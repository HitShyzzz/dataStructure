package interview;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/22:41
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(a + b);
        }
    }
}
