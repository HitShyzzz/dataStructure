package leecode.二分查找;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/10/20:51
 * @Description:
 */
public class 咒语和药水的成功对数 {
    public static void main(String[] args) {
        int[] spells = {15, 8, 19};
        int[] potions = {38, 36, 23};
        long success = 328;
        int[] ints = successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(ints));
    }

    // 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
    // 输出：[4,0,3]
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            if ((long) spells[i] * potions[m - 1] < success) {
                pairs[i] = 0;
                continue;
            }
            if ((long) spells[i] * potions[0] >= success) {
                pairs[i] = m;
                continue;
            }
            int l = 0;
            int r = m - 1;
            // 我们要找的target满足s[i]*p[target]>=success&&s[i]*p[target-1]<success!
            while (l <= r) {
                int mid = (l + r) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    if (mid == 0 || (long) spells[i] * potions[mid - 1] < success) {
                        pairs[i] = m - mid;
                        break;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    l = mid + 1;
                }
            }
        }
        return pairs;
    }
}
