package leecode.剑指offer突击版;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/9:01
 * @Description:
 */
public class 替换单词方法2 {
    // 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
    // 输出："a a a a a a a a bbb baba a"

    /**
     * 前缀树，对于每一个单词我们都去找它的最短前缀单词
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        // 先去构建前缀树字典
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            // 以#结尾
            cur.children.put('#', new Trie());
        }
        // 对于句子中的每个单词，我们去找它的根就可以了
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    /**
     * @param word
     * @param trie
     * @return 单词word在前缀树trie的根
     */
    public String findRoot(String word, Trie trie) {
        StringBuilder sb = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // ＃结尾
            if (cur.children.containsKey('#')) {
                return sb.toString();
            }
            // word不在这棵前缀树上
            if (!cur.children.containsKey(c)) {
                return word;
            }
            sb.append(c);
            cur = cur.children.get(c);
        }
        return sb.toString();
    }


}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }
}
