package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/08/10:50
 * @Description:
 */
public class 统计一致字符串的数目 {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        int i = countConsistentStrings(allowed, words);
        System.out.println(i);
    }

    // allowed = "ab", words = ["ad","bd","aaab","baa","badab"]----》2
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            boolean flag = true;
            for (int j = 0; j < cur.length(); j++) {
                if (allowed.indexOf(cur.charAt(j)) == -1) {
                    // 这一轮计数了就会把flag置为false，但其实没有这个字符的话就要再减回去！
                    if (!flag && count > 0) {
                        count--;
                    }
                    break;
                } else {
                    // 出现的字符只计数1次！
                    if (flag) {
                        count++;
                        flag = false;
                    }
                }
            }
        }
        return count;
    }
}
