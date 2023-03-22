package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/10/9:33
 * @Description:
 */
public class 最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

//    public static int lengthOfLastWord(String s) {
//        String[] str = s.trim().split("\\s+");
//        return str[str.length - 1].length();
//    }

    public static int lengthOfLastWord(String s) {
        String str = s.trim();
        int n = str.length();
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                break;
            } else {
                len++;
            }
        }
        return len;
    }
}
