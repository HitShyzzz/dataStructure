package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-29 20:26
 */
public class 棒球比赛 {
    public static void main(String[] args) {
        String[] operations = {"5", "2", "C", "D", "+"};
        int i = calPoints(operations);
        System.out.println(i);
    }

    // 输入：ops = ["5","-2","4","C","D","9","+","+"]
    // 输出：27
    // 解释：
    // "5" - 记录加 5 ，记录现在是 [5]
    // "-2" - 记录加 -2 ，记录现在是 [5, -2]
    // "4" - 记录加 4 ，记录现在是 [5, -2, 4]
    // "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
    // "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
    // "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
    // "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
    // "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
    // 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
    public static int calPoints(String[] operations) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String cur = operations[i];
            int n = list.size();
            if (cur.equals("C")) {
                sum -= list.get(n - 1);
                list.remove(n - 1);
            } else if (cur.equals("D")) {
                int b = 2 * list.get(n - 1);
                sum += b;
                list.add(b);
            } else if (cur.equals("+")) {
                int c = list.get(n - 1);
                int d = list.get(n - 2);
                sum += (c + d);
                list.add(c + d);
            } else {
                int a = Integer.parseInt(cur);
                list.add(a);
                sum += a;
            }
        }
        return sum;
    }
}
