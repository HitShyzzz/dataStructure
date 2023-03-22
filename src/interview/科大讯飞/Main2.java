package interview.科大讯飞;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/19:56
 * @Description:
 */
public class Main2 {
    /**
     * 凸四边形面积=Math.sqrt((p-a)*(p-b)*(p-c)*(p-d)-a*b*c*d*Math.pow(cos((A+C)/2),2));
     * 其中p=(a+b+c+d)/2;
     *
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public long getArea(Point p1, Point p2, Point p3, Point p4) {
        // write code here
        double a = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        double b = Math.sqrt(Math.pow(p2.x - p3.x, 2) + Math.pow(p2.y - p3.y, 2));
        double c = Math.sqrt(Math.pow(p3.x - p4.x, 2) + Math.pow(p3.y - p4.y, 2));
        double d = Math.sqrt(Math.pow(p4.x - p1.x, 2) + Math.pow(p4.y - p1.y, 2));
        double e = Math.sqrt(Math.pow(p2.x - p4.x, 2) + Math.pow(p2.y - p4.y, 2));
        long area1 = area(a, e, d);
        long area2 = area(e, b, c);
        return area1 + area2;
    }

    public long area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return (long) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
