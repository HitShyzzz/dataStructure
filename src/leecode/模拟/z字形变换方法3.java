package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/15/23:00
 * @Description:
 */
public class z字形变换方法3 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    /**
     * 找规律，对于第0行的下标都满足inex%t==0,对于最后一行都满足index%(r-1)==0;
     * 对于其他行i,一个周期内有两个满足要求的下标，第一个小标index==(i)%t,第二个下标满足index==(t-i)%t;
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        String ans = "";
        int t = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += t) {
                ans += s.charAt(i + j);// 周期内的第一个字符
                if (i > 0 && i < numRows - 1 && t - i + j < n) {
                    ans += s.charAt(t - i + j);// 周期内的第二个字符，只有对非第一行和最后一行的才需要添加；
                }
            }
        }
        return ans;
    }
}
