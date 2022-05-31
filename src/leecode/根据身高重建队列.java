package leecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/25/10:07
 * @Description:
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = reconstructQueue(people);
        for (int i = 0; i < queue.length; i++) {
            System.out.print("[" + queue[i][0] + "," + queue[i][1] + "]" + " ");
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 把原数组按身高升序排列，按k降序排列；
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;// 第i个人的位置就是ki+1个空位置
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    spaces--;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
