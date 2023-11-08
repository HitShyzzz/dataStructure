package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/07/21:04
 * @Description:
 */
public class 统计范围内的元音字符串数 {
    public static void main(String[] args) {
        String[] words = {"hey", "aeo", "mu", "ooo", "artro"};
        int left = 1;
        int right = 4;
        int i = vowelStrings(words, left, right);
        System.out.println(i);
    }

    // 输入：words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
    // 输出：3
    public static int vowelStrings(String[] words, int left, int right) {
        String vowelString = "aeiou";
        int cnt = 0;
        left = left < 0 ? 0 : left;
        right = right >= words.length ? words.length - 1 : right;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            if (vowelString.indexOf(start) != -1 && vowelString.indexOf(end) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
