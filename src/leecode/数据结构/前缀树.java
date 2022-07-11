package leecode.数据结构;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/10:53
 * @Description:
 */
public class 前缀树 {

}

class Trie {
    private Trie[] children;// 子节点数组
    private boolean isEnd;// 标记是否到了末尾

    public Trie() {
        children = new Trie[26];// 26个小写英文字母
        isEnd = false;
    }

    /**
     * 插入操作，先判断当前结点是否存在，如果不存在，则要先去创建结点；
     * 如果存在，就把当前结点指向孩子结点的下一个；
     * 走到最后了，还要把isEnd标志置为true；
     *
     * @param word
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            // 当前字符不存在
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 如果已经存在,就把指针指向孩子结点，继续去判断下一个字符！
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * 先去查找前缀，如果前缀已经存在了，并且也到了末尾，就说明找到了！
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * 直接查找前缀就好了！
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * 查找word的前缀
     *
     * @param word
     * @return
     */
    public Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
