package interview.华为OD;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-11 20:06
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<String> strings = get(n);
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("Result:" + strings.size());
        }
    }

    public static List<String> get(int n) {
        int[] pre = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + i;
            map.put(pre[i], i);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(pre[i] + n)) {
                StringBuilder cur = new StringBuilder(n + "=");
                int end = map.get(pre[i] + n);
                for (int j = i + 1; j <= end; j++) {
                    cur.append(j + "+");
                }
                cur.deleteCharAt(cur.length() - 1);
                ans.add(cur.toString());
            }
        }
        Collections.sort(ans, (o1, o2) -> o1.length()-o2.length());
        return ans;
    }
}
