package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/02/20/9:32
 * @Description:
 */
public class 最好的扑克手牌 {
    // ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]===》"Three of a Kind"
    public String bestHand(int[] ranks, char[] suits) {
        // 判断花色是否都相同
        boolean isSame = true;
        for (int i = 0; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            return "Flush";
        }
        // 统计每张扑克牌的数量
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
            if (map.get(rank) >= 3) {
                return "Three of a Kind";
            }
        }
        // 高牌
        if (map.size() == 5) {
            return "High Card";
        }
        return "Pair";
    }
}
