package interview.京东;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/20:16
 * @Description:
 */
public class Main2 {
    public static class Help {
        public int good;
        public int minCost;

        public Help(int good, int minCost) {
            this.good = good;
            this.minCost = minCost;
        }
    }

    public static Help solve(int[] arr, int index, int prepre, int pre) {
        if (index == arr.length) {
            return new Help(0, 0);
        }
        // 两个相同
        int best = 0;
        int minCost = Integer.MAX_VALUE;
        // 三数相等
        if (prepre == pre && pre == arr[index]) {
            for (int i = 0; i <= 2; i++) {
                if (i == pre) {
                    continue;
                }
                Help help = solve(arr, index + 1, pre, i);
                help.minCost += 1;
                if (help.minCost < minCost) {
                    minCost = help.minCost;
                    best = help.good;
                }
            }
        } else if (pre == arr[index]) {
            for (int i = 0; i <= 2; i++) {
                if (i == pre || i == prepre) {
                    continue;
                }
                Help help = solve(arr, index + 1, pre, i);
                help.minCost += 1;
                if (help.minCost < minCost) {
                    minCost = help.minCost;
                    best = help.good;
                }
            }
        } else {
            Help help = solve(arr, index + 1, pre, arr[index]);
            if (help.minCost < minCost) {
                minCost = help.minCost;
                best = help.good;
            }
        }
        return new Help(best, minCost);
    }

    public static int solution(String str) {
        int n = str.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char cur = str.charAt(i);
            if (cur == 'd') {
                arr[i] = 0;
            } else if (cur == 'e') {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        int good = 0;
        int minCost = Integer.MAX_VALUE;
        for (int prepre = 0; prepre < 3; prepre++) {
            for (int pre = 0; pre < 3; pre++) {
                if (pre == prepre) {
                    continue;
                }
                int cost = (arr[0] == prepre) ? 0 : 1;
                cost += (arr[1] == pre) ? 0 : 1;
                Help help = solve(arr, 2, prepre, pre);
                if (help.good > good) {
                    good =help.good;
                    minCost = help.minCost + cost;
                } else if (help.good == good) {
                    minCost = Math.min(minCost, help.minCost + cost);
                }
            }
        }
        return minCost;
    }

    // rrdd 2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
