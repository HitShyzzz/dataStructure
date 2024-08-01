package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-01 20:20
 */
public class 心算挑战 {
    public static void main(String[] args) {
        int[] cards = {3, 3, 1};
        int cnt = 1;
        int i = maxmiumScore(cards, cnt);
        System.out.println(i);
    }

    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int sum = 0;
        int i = cards.length - 1;
        int n = cards.length;
        // 后面cnt个较大数中的最小偶数
        int even = 100000;
        // 后面cnt个较大数中的最小奇数
        int odd = 100001;
        while (i >= n - cnt) {
            if (cards[i] % 2 == 0) {
                even = cards[i];
            } else {
                odd = cards[i];
            }
            sum += cards[i];
            i--;
        }
        if (sum % 2 == 0) {
            return sum;
        }
        // 如果cnt个较大数的和不是奇数，此时有两种方案：
        // 1、从[0,i]中找到最大的偶数换掉odd
        // 2、从[0,i]中找到最大的奇数换掉even
        // 二者取最大值去更新ans
        int j = 0;
        int ans = 0;
        while (j <= i) {
            if (cards[j] % 2 == 0) {
                ans = Math.max(ans, sum - odd + cards[j]);
            } else {
                ans = Math.max(ans, sum - even + cards[j]);
            }
            j++;
        }
        return ans;
    }
}
