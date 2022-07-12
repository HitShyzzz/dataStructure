package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/22:24
 * @Description:
 */
public class 字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //in.nextLine();
        while (in.hasNext()) {
            String[] s = in.nextLine().split(",");
            Arrays.sort(s);
            for (int i = 0; i < s.length - 1; i++) {
                System.out.print(s[i] + ",");
            }
            System.out.print(s[s.length - 1]);
            System.out.println();
        }
    }
}
