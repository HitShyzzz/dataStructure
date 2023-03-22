package interview.四399;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/15/21:41
 * @Description:
 */
public class 到达终点路径个数 {
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        dfs(m, n, 3, m, n);
        System.out.println(cnt);
    }

    public static void dfs(int m, int n, int sum, int i, int j) {
        if (i == 0 && j == 0 && sum == 0) {
            cnt++;
        }
        if (i < 0 || j < 0) {
            return;
        }
        // 提前结束
        if ((i > 0 || j > 0) && (sum <= 0)) {
            return;
        }
        dfs(m, n, sum * 2, i - 1, j);
        dfs(m, n, sum - 1, i, j - 1);
    }
}
