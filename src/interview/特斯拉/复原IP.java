package interview.特斯拉;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/22/21:43
 * @Description:
 */
public class 复原IP {
    public static List<String> list = new ArrayList<>();
    public static int[] segments = new int[4];

    public static void main(String[] args) {
        String s = "0000";
        List<String> list1 = restoreIpAddresses(s);
        for (String ss : list1) {
            System.out.print(ss + " ");
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        segments = new int[4];
        dfs(s, 0, 0);
        return list;
    }

    // 表示我们从start位置开始，搜索第id段的ip值
    public static void dfs(String s, int id, int start) {
        // 如果已经搜索到第4段，且字符串s都遍历完了，就要停下来！
        if (id == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    sb.append(segments[i]);
                    if (i != 3) {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            return;
        }
        // 如果提前遍历到了字符串末尾，也要停下来
        if (start == s.length()) {
            return;
        }
        // 不能有前导0
        if (s.charAt(start) == '0') {
            segments[id] = 0;
            dfs(s, id + 1, start + 1);
        }
        // 一般情形
        int sum = 0;
        for (int i = start; i < s.length(); ++i) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > 0 && sum <= 255) {
                segments[id] = sum;
                dfs(s, id + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
