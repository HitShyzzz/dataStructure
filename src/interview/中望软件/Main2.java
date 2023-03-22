package interview.中望软件;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/20:30
 * @Description:
 */
public class Main2 {
    public boolean judge(double[] point1, double[] point2, double[] point3, double[] point) {
        // write code here
        double x = point[0];
        double y = point[1];
        double k1 = (point1[1] - point2[1]) / (point1[0] - point2[0]);
        double b1 = point1[1] - k1 * point[0];
        double k2 = (point1[1] - point3[1]) / (point1[0] - point3[0]);
        double b2 = point1[1] - k2 * point[0];
        double k3 = (point2[1] - point3[1]) / (point2[0] - point3[0]);
        double b3 = point2[1] - k3 * point2[0];
        if (y >= k1 * x + b1) {
            return false;
        }
        if (y >= k2 * x + b2) {
            return false;
        }
        if (y <= k3 * x + b3) {
            return false;
        }
        return true;
    }
}
