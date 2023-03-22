package interview.美团;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/20/10:42
 * @Description:
 */
public class 翻牌游戏 {
    public static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] front = new int[n];
        int[] back = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            front[i] = in.nextInt();
            sum += front[i];
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            back[i] = in.nextInt();
        }
        in.close();
        dfs(sum, front, back, 0, 0);
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }

    }

    public static void dfs(int sum, int[] front, int[] back, int count, int index) {
        if (sum == 0) {
            minCount = Math.min(minCount, count);
            return;
        }
        if (index == front.length) {
            return;
        }
        // 不翻当前这张牌
        dfs(sum, front, back, count, index + 1);
        // 翻当前这张牌
        sum += (back[index] - front[index]);
        dfs(sum, front, back, count + 1, index + 1);
    }
}
