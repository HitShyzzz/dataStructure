package interview.字节;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/18/9:28
 * @Description:
 */
public class 特征提取方法2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        Pair[][] matrix = new Pair[m][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s = in.nextLine();
                String[] s1 = s.split(" ");
                int len = 0;
                len = Integer.valueOf(s1[0]);
                matrix[j] = new Pair[len];
                for (int k = 0; k < len; k++) {
                    int l = 2 * k + 1;
                    int x = Integer.parseInt(s1[l]);
                    int y = Integer.parseInt(s1[l + 1]);
                    matrix[j][k] = new Pair(x, y);
                }
            }
            int max = 1;
            Map<int[], Integer> preMap = new HashMap<>();
            for (int s = 0; s < m; s++) {
                Map<int[], Integer> curMap = new HashMap<>();
                for (int l = 0; l < matrix[s].length; l++) {
                    int x = matrix[s][l].x;
                    int y = matrix[s][l].y;
                    int[] nums = {x, y};
                    curMap.put(nums, 1);
                    for (int[] keys : preMap.keySet()) {
                        if ((keys[0] == x) && (keys[1] == y)) {
                            int len = preMap.get(keys) + 1;
                            curMap.put(nums, len);
                            max = Math.max(max, len);
                        }
                    }
                }
                preMap = curMap;
            }
            System.out.println(max);
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

