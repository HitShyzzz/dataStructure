package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 19:30
 */
class Trie {

    // 每个节点的子节点，
    private Trie[] children;

    // 每个节点是否已经到了末尾
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 如果是新插入的字符串（之前前缀没有该字符），就新建Trie对象
            if (node.children[index] == null) node.children[index] = new Trie();
            // 当前节点继续往下走
            node = node.children[index];
        }
        // 最后把该节点的末尾标记置为true
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 如果该子对象不存在（找不到该字符），就返回false
            if (node.children[index] == null) return false;
            // 当前节点继续往下走
            node = node.children[index];
        }
        // 判断是否走到了末尾
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            // 如果该子对象不存在（找不到该字符），就返回false
            if (node.children[index] == null) return false;
            // 当前节点继续往下走
            node = node.children[index];
        }
        // 都已经走到末尾了，肯定是前缀
        return true;
    }
}
