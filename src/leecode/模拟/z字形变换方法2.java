package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/15/22:18
 * @Description:
 */
public class z字形变换方法2 {
    public static void main(String[] args) {
        String s = "PA";
        int numRows = 1;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    /**
     * 方法1中先构造了矩阵，而我们的结果集中只要矩阵的非空元素，那么大量的空元素是比较浪费空间的；
     * 我们可以压缩矩阵来进行优化，我们可以构造一个字符串数组，最后把这个字符串数组的字符串加到结果集就行了，每行
     * 构造一个空的列表，每次都要元素加到每行列表的末尾就行了；
     *O(T)=O(n);O(S)=O(numRows);
     * @param s       原字符串
     * @param numRows 行的数量
     * @return z字形变换的结果
     */
    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = 2 * numRows - 2;
        StringBuilder sb[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        String ans = "";
        int row = 0;
        for (int i = 0; i < n; i++) {
            sb[row].append(s.charAt(i));
            if (i % t < numRows - 1) {
                row++;
            } else {
                row--;
            }
        }
        for (StringBuilder s1 : sb) {
            System.out.println(s1);
            ans += s1.toString();
        }
        return ans;
    }
}
