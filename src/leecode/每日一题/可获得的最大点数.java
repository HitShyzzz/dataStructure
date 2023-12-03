package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-12-03 10:54
 */
public class 可获得的最大点数 {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int i = maxScore(cardPoints, k);
        System.out.println(i);
    }

    /**
     * @description: 依次从两端取值使得最终最大，那么最后未选择的n-k个元素一定是连续的!
     * 滑动窗口解决，维护n-k长度的窗口，那么res=Math.max(res,sum-window)!
     * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
     * 输出：202
     * @author: shy
     * @date: 2023/12/3 12:49
     * @param: cardPoints
     * @param: k
     * @return: int
     **/
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }
        if (k == cardPoints.length) {
            return sum;
        }
        int n = cardPoints.length;
        int window = 0;
        for (int i = 0; i < n - k; i++) {
            window += cardPoints[i];
        }
        int res = sum - window;
        for (int i = 1; i < k + 1; i++) {
            window = window - cardPoints[i - 1] + cardPoints[i + n - k - 1];
            res = Math.max(res, sum - window);
        }
        return res;
    }
}
