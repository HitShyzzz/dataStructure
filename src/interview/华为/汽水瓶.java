package interview.华为;

import java.util.Scanner;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 17:26
 */
public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a=in.nextInt();
            if (a==0){
                break;
            }
            System.out.println(get(a));
        }
    }

    public static int get(int n) {
        int cnt = 0;
        while (n != 0) {
            int dev = n / 3;
            int res = n % 3;
            cnt += dev;
            n = dev + res;
            if (n == 2) {
                cnt += 1;
                break;
            }
            if (dev == 0) {
                break;
            }
        }
        return cnt;
    }
}
