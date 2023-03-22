package interview;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/13/14:35
 * @Description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[]ans=new int[T];
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int x[] = new int[n];
            int y[] = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = in.nextInt();
            }
            for (int k = 0; k < n; k++) {
                y[k] = in.nextInt();
            }
            for (int l = 0; l < n; l++) {
                for (int s = l + 1; s < n; s++) {
                    if (x[l] > x[s] && (y[l] > y[s]) || (x[l] < x[s] && (y[l] < y[s]))) {
                        ans[i]++;
                    }
                }
            }
        }
        for(int i=0;i<T;i++){
            System.out.println(ans[i]);
        }
    }
}
