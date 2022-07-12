package interview;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/16:50
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sum = 0;
            String[] s = in.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                int num = Integer.parseInt(s[i]);
                sum += num;
            }
            System.out.println(sum);
        }
    }
}
