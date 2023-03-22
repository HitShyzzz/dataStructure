package interview.字节;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/29/20:59
 * @Description:
 */
public class 校对字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder[] s = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            s[i] = new StringBuilder(in.next());
        }
        for (int i = 0; i < N; i++) {
            StringBuilder cur = s[i];
            for (int j = 0; j+2< cur.length(); j++) {
                char a= cur.charAt(j);
                char b=cur.charAt(j+1);
                char c= cur.charAt(j+2);
                // 三个连续相等的，删除一个
                if(a==b&&(b==c)){
                    // 删除了一个，每次都要从前面一个位置往后面扫描
                    cur.deleteCharAt(j--);
                }
            }
            for(int j=0;j<cur.length();j++){
                // AABB的删除第一个B
                if (j + 3 < cur.length() && (cur.charAt(j) == cur.charAt(j + 1)) && (cur.charAt(j + 2) == cur.charAt(j + 3))) {
                    cur.deleteCharAt(j + 2);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(s[i].toString());
        }
    }
}
