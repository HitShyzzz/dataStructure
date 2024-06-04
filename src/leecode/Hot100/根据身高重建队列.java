package leecode.Hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-04 22:10
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(people);
        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 按身高从低到高排序，再按照ki从大到小排序
        // 按照ki从大到小排序的目的是让相同身高的人,ki更大的人先去站位置，避免ki小的元素先去站位置对Ki大的元素产生影响
        // 不按照ki从大到小排，跑一个例子就明白了
        Arrays.sort(people, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1]);
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            // 第i个人的位置在ki+1,也就是前面要空出ki个位置来让比它高的人去站
            int pos = person[1] + 1;
            for (int i = 0; i < n; i++) {
                // 只在空位置进行更新
                if (ans[i] == null) {
                    pos--;
                    if (pos == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
