package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/22:58
 * @Description:
 */
public class 汉明距离 {
    /**
     * 先求异或结果，再去计算异或结果中二进制数字1的个数就行了！
     * 此外，Integer.bitCount()函数就可以直接返回二进制1的个数！
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        return Integer.bitCount(n);
        //return count(n);
    }

    /**
     * @param n
     * @return n的二进制表示1的个数
     */
    public int count(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
