package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/17/9:07
 * @Description:
 */
public class 统计共同度过的日子数 {
    // arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
    // 3
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthsDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 计算一下当前日期是一年的第几天
        int[] preMonthsDay = new int[13];
        for (int i = 0; i < 12; i++) {
            preMonthsDay[i + 1] = preMonthsDay[i] + monthsDay[i];
        }
        int AliceArriveDay = cntOfDay(preMonthsDay, arriveAlice);
        int AliceLeaveDay = cntOfDay(preMonthsDay, leaveAlice);
        int BobArriveDay = cntOfDay(preMonthsDay, arriveBob);
        int BobLeaveDay = cntOfDay(preMonthsDay, leaveBob);
        int arrive = Math.max(AliceArriveDay, BobArriveDay);
        int leave = Math.min(BobLeaveDay, AliceLeaveDay);
        if (leave < arrive) {
            return 0;
        }
        return leave - arrive + 1;
    }

    /**
     * @param preMonthsDay
     * @param s
     * @return 字符串s是在一年的第几天
     */
    public int cntOfDay(int[] preMonthsDay, String s) {
        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3));
        return preMonthsDay[month - 1] + day;
    }
}
