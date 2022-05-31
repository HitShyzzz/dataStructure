package leecode.拓扑排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/31/9:26
 * @Description:
 */
public class 外星文字典 {
    public String alienOrder(String[] words) {
        boolean[] has = new boolean[26];// 记录字母是否出现过
        char[][] c = new char[words.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = words[i].toCharArray();
            for (int j = 0; j < c[i].length; j++) {
                has[c[i][j] - 'a'] = true;
            }
        }
        // 反向建图，存储某个节点的儿子节点
        List<Integer> son[] = new List[26];
        // 正向建图，存储某个节点的父亲节点
        Set<Integer> father[] = new Set[26];
        for (int i = 0; i < 26; i++) {
            son[i] = new ArrayList<>();
            father[i] = new HashSet<>();
        }
        // 正反向建图
        for (int i = 1; i < 26; i++) {
            int p = 0;
            while (p < Math.min(c[i].length, c[i - 1].length) && c[i][p] == c[i - 1][p]) p++;
            // 后者是前者的真前缀，此时不合法，直接返回“”；如["abc","ab"];
            if (p == c[i].length && p < c[i - 1].length) {
                return "";
            }
            if (p < c[i].length && p < c[i - 1].length) {
                if (father[c[i][p] - 'a'].add(c[i - 1][p] - 'a')) {
                    son[c[i - 1][p] - 'a'].add(c[i][p] - 'a');
                }
            }
        }
        // BFS用的队列
        Queue<Integer> queue = new LinkedList<>();
        // 结果集
        StringBuilder ans = new StringBuilder();
        // 先把没有父节点的字母加进队列
        for (int i = 0; i < 26; i++) {
            if (has[i] && father[i].size() == 0) {
                ans.append((char) (i + 'a'));
                has[i] = false;
                queue.add(i);
            }
        }
        // 开始BFS
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int i = 0; i < son[a].size(); i++) {
                int b = son[a].get(i);
                father[b].remove(a);
                // 此时这个节点的祖先节点都已经被访问了，且都已经加到字母表了。
                if (father[b].size() == 0) {
                    ans.append((char) (b + 'a'));
                    has[b] = false;
                    queue.add(b);
                }
            }
        }
        // 下面检查set中是否存在环，同时把没有关系的字母加进来
        for (int i = 0; i < 26; i++) {
            if (father[i].size() > 0) {
                return "";
            }
            if (has[i]) {
                ans.append((char) (i + 'a'));
            }
        }
        return ans.toString();
    }
}
