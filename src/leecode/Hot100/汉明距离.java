package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 18:54
 */
public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        // 异或结果1的位数
        return Integer.bitCount(x^y);
    }
}
