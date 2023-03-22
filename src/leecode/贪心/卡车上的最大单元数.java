package leecode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/15/9:41
 * @Description:
 */
public class 卡车上的最大单元数 {
    public static void main(String[] args) {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int i = maximumUnits(boxTypes, truckSize);
        System.out.println(i);
    }

    // boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10---》91
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        for (int box[] : boxTypes) {
            int count = box[0];
            int unit = box[1];
            if (count <= truckSize) {
                ans += count * unit;
                truckSize = truckSize - count;
            } else if (truckSize > 0) {
                ans += truckSize * unit;
                break;
            }
        }
        return ans;
    }
}
