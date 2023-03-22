package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/25/12:24
 * @Description:
 */
public class 情感丰富的文字 {
    // s = "heeellooo" words = ["hello", "hi", "helo"]----->1
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (match(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @param s    heeellooo
     * @param word hello
     * @return 字符串s是否能由word扩展而来
     */
    public boolean match(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            char c = s.charAt(i);
            int cnts = 0;
            while (i < s.length() && s.charAt(i) == c) {
                cnts++;
                i++;
            }
            int cntw = 0;
            while (j < word.length() && word.charAt(j) == c) {
                cntw++;
                j++;
            }
            if (cnts < cntw) {
                return false;
            }
            if (cnts > cntw && cnts < 3) {
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }
}
