package interview.特斯拉;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/18:01
 * @Description:
 */
public class 添加5 {
    public static void main(String[] args) {
        int n = -25;
        int i = add5(n);
        System.out.println(i);
    }

    /**
     * @param n
     * @return 在n添加5求最大值和最小值之差
     */
    public static int add5(int n) {
        if (n == 0) {
            return 45;
        }
        int cur = Math.abs(n);
        int cnt = 0;// 求出n的位数
        while (cur != 0) {
            cnt++;
            cur = cur / 10;
        }
        int operation = 5;
        for (int i = 0; i < cnt; i++) {
            operation = operation * 10;
        }
        int max = operation + Math.abs(n);
        System.out.println(max);
        int min = Math.abs(n)*10 + 5;
        System.out.println(min);
        return max - min;
    }
}
