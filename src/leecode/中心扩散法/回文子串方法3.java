package leecode.中心扩散法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/12:06
 * @Description:
 */
public class 回文子串方法3 {
    /**
     * 中心扩散法：以center为中心，如果center左边left字符和右边right字符相等，就能不停的向两边扩展！
     * 以单个字符为中心的有n个，以两个字符为中心的有n-1个，因此总共有2n-1个中心！
     * O(T)=O(n^2),最坏情况下，s里的字符全部相等，那么对于每个center都要扩展全部字符，需要O(n)的时间，总共有2n-1个center，
     * 总的时间复杂度就是O(n^2);
     * O(S)=O(1);
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            // center为偶数时，左右指针指向同一个字符，center为奇数时，右指针指向左指针后面的一个字符！
            // 如s="abc",center依次是a,ab,b,bc,c;
            int right = left + center % 2;
            // 如果左右指针相等，就能往两边扩展
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
