package interview.京东;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/23:04
 * @Description:
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        int jd = 1;
        for(int i = 0;i < s.length();i++){
            while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                jd++;
                i++;
            }
            ans += (jd+1)/3;
            jd = 1;
        }
        System.out.println(ans);
    }
}
