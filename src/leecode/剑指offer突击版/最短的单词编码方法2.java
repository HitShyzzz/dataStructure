package leecode.剑指offer突击版;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/10:10
 * @Description:
 */
public class 最短的单词编码方法2 {
    /**
     * 我们想找的是没有公共后缀的单词，那么ans+=没有公共后缀的单词的长度+1（有＃号）
     * 那么我们如果反向遍历字符串后缀不就变成前缀了嘛
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        TrieNode trieNode = new TrieNode();
        Map<TrieNode, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trieNode;
            for (int j = word.length() - 1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            map.put(cur, i);
        }
        int res = 0;
        for (TrieNode trie : map.keySet()) {
            // 子节点个数为0，也就是叶子结点，对于 time me 这种me的子节点个数就不是0，所以就不会添加到结果集
            if (trie.count == 0) {
                res += words[map.get(trie)].length() + 1;
            }
        }
        return res;
    }
}

class TrieNode {
    public TrieNode[] children;// 孩子结点
    public int count;// 孩子结点的数量

    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    // 返回字符c的前缀树结点
    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
