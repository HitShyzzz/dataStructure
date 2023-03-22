package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/02/10:08
 * @Description:
 */
public class 网络信号最好的坐标 {
    public static void main(String[] args) {
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;
        int[] ints = bestCoordinate(towers, radius);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
    // 暴力枚举
    public static int[] bestCoordinate(int[][] towers, int radius) {
        // 先确定信号最好点坐标的范围
        int xMax = 0;
        int yMax = 0;
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            if (x > xMax) {
                xMax = x;
            }
            if (x < xMin) {
                xMin = x;
            }
            if (y > yMax) {
                yMax = y;
            }
            if (y < yMin) {
                yMin = y;
            }
        }
        int[] ans = new int[2];
        int totalSignal = 0;
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                int temp = 0;
                for (int[] tower : towers) {
                    int x = tower[0];
                    int y = tower[1];
                    int q = tower[2];
                    double d = Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2));
                    if (d > radius) {
                        continue;
                    }
                    int cur = (int) Math.floor(q / (1 + d));
                    temp += cur;
                }
                if (temp > totalSignal) {
                    totalSignal = temp;
                    ans = new int[]{i, j};
                }
            }
        }
        return ans;
    }
}
