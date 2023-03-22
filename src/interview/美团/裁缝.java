package interview.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/19/23:17
 * @Description:
 */
public class 裁缝 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String target = in.nextLine();
        System.out.println(target);
        in.nextLine();
        String[] fragments = new String[m];
        for (int i = 0; i < m; i++) {
            fragments[i] = in.nextLine();
        }
        for (String s : fragments) {
            System.out.println(s + " ");
        }
        System.out.println();
        dfs(target, new StringBuilder(), fragments, new boolean[m]);
        System.out.println(count);
    }

    /**
     * 我们现在把fragments数组元素拼起来，看有多少种拼法能成功拼出来target，就是我们想要的答案！
     *
     * @param target
     * @param sb
     * @param fragments
     * @param used
     */
    public static void dfs(String target, StringBuilder sb, String[] fragments, boolean[] used) {
        if (target.equals(sb.toString())) {
            count++;
            return;
        }
        for (int i = 0; i < fragments.length; i++) {
            if (used[i]) {
                continue;
            }
            sb.append(fragments[i]);
            used[i] = true;
            dfs(target, sb, fragments, used);
            // 回溯
            sb.delete(sb.length() - fragments[i].length(), sb.length());
            used[i] = false;
        }
    }
}

