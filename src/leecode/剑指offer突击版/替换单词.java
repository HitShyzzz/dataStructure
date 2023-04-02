package leecode.剑指offer突击版;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/9:01
 * @Description:
 */
public class 替换单词 {
    // 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
    // 输出："a a a a a a a a bbb baba a"
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String cur = s[i];
            boolean flag = false;// 标志字典中是否有当前单词
            for (int j = 1; j <= cur.length(); j++) {
                if (dictionary.contains(cur.substring(0, j))) {
                    flag = true;
                    sb.append(cur.substring(0, j) + " ");
                    break;
                }
            }
            if (!flag) {
                sb.append(cur + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
