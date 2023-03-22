package interview.百度;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/15/20:20
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String s1 = in.nextLine();
            String[] temp = s1.split(" ");
            int m = Integer.parseInt(temp[0]);
            int p = Integer.parseInt(temp[1]);
            String s = in.nextLine();
            ans[i] = p;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
