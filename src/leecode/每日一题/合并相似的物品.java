package leecode.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/02/28/8:06
 * @Description:
 */
public class 合并相似的物品 {
    // 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
    // 输出：[[1,6],[3,9],[4,5]]
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            int value = item[0];
            int weight = item[1];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + weight);
            } else {
                map.put(value, weight);
            }
        }
        List<Integer> Sortedlist = new ArrayList<>(map.keySet());
        Collections.sort(Sortedlist);
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : Sortedlist) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            ans.add(list);
        }
        return ans;
    }
}
