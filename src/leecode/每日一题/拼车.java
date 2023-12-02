package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-12-02 14:59
 */
public class 拼车 {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        boolean b = carPooling(trips, capacity);
        System.out.println(b);
    }

    // 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
    // 输出：true
    public static boolean carPooling(int[][] trips, int capacity) {
        // 找到索引最大值
        int maxTo = 0;
        for (int i = 0; i < trips.length; i++) {
            maxTo = Math.max(maxTo, trips[i][2]);
        }
        int[] diff = new int[maxTo + 1];
        // 在某一时刻有人上车了，需要的座位就加，在某一时刻有人下车了，需要的作为就减
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int cnt = 0;
        for (int i = 0; i < diff.length; i++) {
            cnt += diff[i];
            if (cnt > capacity)
                return false;
        }
        return true;
    }
}
