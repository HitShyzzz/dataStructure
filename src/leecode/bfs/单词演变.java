package leecode.bfs;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/21/9:15
 * @Description:
 */
public class 单词演变 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }

    // 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //输出：5
    //解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int ans = 1;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (String x : get(s, wordList)) {
                    if (!seen.contains(x)) {
                        if (x.equals(endWord)) {
                            return ans;
                        }
                        seen.add(x);
                        queue.offer(x);
                    }
                }
            }
        }
        return 0;
    }

    /**
     * @param s
     * @param wordList
     * @return 字符串s和wordList中字符串只相差一位的集合
     */
    public static List<String> get(String s, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String word : wordList) {
            int dif = 0;
            for (int i = 0; i < word.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    dif++;
                }
                if (dif > 1) {
                    break;
                }
            }
            if (dif == 1) {
                res.add(word);
            }
        }
        return res;
    }
}
