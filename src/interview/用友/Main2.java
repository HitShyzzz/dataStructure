package interview.用友;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/15:38
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        StringBuilder sb = new StringBuilder();
        // clientIPAddress
        // client_ip_address
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && Character.isLowerCase(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            if (i<s.length()&& Character.isUpperCase(s.charAt(i))){
                // 遇到大写字母
                sb.append("_");
            }
            // 找到最后一个大写字母的前面
            while (i < s.length() && Character.isUpperCase(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
                i++;
            }
            // 不到最后一个位置就加上_
            if (i < s.length()&&Character.isUpperCase(s.charAt(i-2))) {
                sb.replace(sb.length() - 1, sb.length(), "_" +Character.toLowerCase(s.charAt(i - 1)));
            }
        }
        System.out.println(sb.toString());
    }
}
