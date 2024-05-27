package leecode.每日一题;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-22 20:39
 */
public class 找出输掉零场或者一场比赛的玩家 {
    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        //int[][] matches = {{1, 2}, {2, 1}};
        List<List<Integer>> winners = findWinners(matches);
        System.out.println(winners);
    }

    // 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
    // 输出：[[1,2,10],[4,5,7,8]]
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>(2);
        // 统计每个节点输的次数
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
            set.add(loser);
            if (!set.contains(winner)) {
                map.put(winner, 0);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 0) {
                list1.add(key);
            }
            if (value == 1) {
                list2.add(key);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
