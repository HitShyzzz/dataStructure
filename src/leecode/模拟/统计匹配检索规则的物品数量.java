package leecode.模拟;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/29/10:29
 * @Description:
 */
public class 统计匹配检索规则的物品数量 {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        String[] key = {"type", "color", "name"};
        int ans = 0;
        for (List<String> item : items) {
            for (int i = 0; i < key.length; i++) {
                if (key[i].equals(ruleKey) && item.get(i).equals(ruleValue)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
