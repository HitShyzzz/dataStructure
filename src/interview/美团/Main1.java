package interview.美团;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/03/11:03
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[]str=s.split(" ");
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[1]);
        if (a>=11&&a-b>=2){
            System.out.println(0);
        } else if (a>=11&&a-b<2) {
            System.out.println(2-(a-b));
        } else if (a<11&&b<=9) {
            System.out.println(11-a);
        } else if (a<11&&b<11) {
            System.out.println(11-a+1);
        } else if (a<11) {
            System.out.println(11-a+2);
        }
    }
}
