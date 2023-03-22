package interview.华为;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/27/19:51
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        int count = str.length;
        float sum = 0f;
        for (int i = 0; i < str.length; i++) {
            sum += str[i].length();
        }
        System.out.printf("%.2f", sum / count);
    }
}
