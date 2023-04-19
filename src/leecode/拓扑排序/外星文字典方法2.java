package leecode.拓扑排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/31/9:26
 * @Description:
 */
public class 外星文字典方法2 {
    // 记录每一个结点的邻接集合
    Map<Character, List<Character>> edges = new HashMap<>();
    // 计算每个字符的入度
    Map<Character, Integer> indegrees = new HashMap<>();
    // 标识当前字符串数组是否有效
    boolean valid = true;

    public String alienOrder(String[] words) {
        int len = words.length;
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 1; i < len && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<>();
        for (Character c : edges.keySet()) {
            // 先把入度为0的点加入到队列
            if (!indegrees.containsKey(c)) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (Character c1 : edges.get(c)) {
                indegrees.put(c1, indegrees.get(c1) - 1);
                if (indegrees.get(c1) == 0) {
                    queue.offer(c1);
                }
            }
        }
        return sb.length() == edges.size() ? sb.toString() : "";
    }

    public void addEdge(String before, String cur) {
        int len1 = before.length();
        int len2 = cur.length();
        int len = Math.min(len1, len2);
        int index = 0;
        while (index < len) {
            char c1 = before.charAt(index);
            char c2 = cur.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }
        // 后面单词是前面单词的真前缀，比如["ab","a"]这样的单词数组是非法的
        if (index == len && len1 > len2) {
            valid = false;
        }
    }
}
