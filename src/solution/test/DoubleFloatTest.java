package solution.test;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/21:10
 * @Description:
 */
public class DoubleFloatTest {
    public static void main(String[] args) {
        String doubleValA = "3.14159267";
        String doubleValB = "2.358";
        System.out.println("add:" + add(doubleValA, doubleValB));
        System.out.println("sub:" + sub(doubleValA, doubleValB));
        System.out.println("mul:" + mul(doubleValA, doubleValB));
        System.out.println("div:" + div(doubleValA, doubleValB, 8));
    }
    // 相加
    public static double add(String doubleValA, String doubleValB) {
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.add(b2).doubleValue();
    }
    // 相减
    public static double sub(String doubleValA, String doubleValB) {
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.subtract(b2).doubleValue();
    }
    // 相乘
    public static double mul(String doubleValA, String doubleValB) {
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.multiply(b2).doubleValue();
    }
    // 相除
    public static double div(String doubleValA, String doubleValB, int scale) {
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
