package leecode.剑指offer突击版;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/10:10
 * @Description:
 */
public class 最短的单词编码 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            // 遍历每一个单词的后缀
            for (int k = 1; k < cur.length(); k++) {
                // 如果set已经包含了后缀单词，那么当前后缀单词就可以从set中删除
                if (set.contains(cur.substring(k, cur.length()))) {
                    set.remove(cur.substring(k, cur.length()));
                }
            }
        }
        int res = 0;
        for (String word : set) {
            res += word.length() + 1;
        }
        return res;
    }
}
