package solution.test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/30/12:33
 * @Description:
 */
public class Hello1 {
    public static void main(String[] args) {
        short a = 25;
        short b = 22;
        final short g = 21, m = 21;
        // 编译器会报错
        // short c=a+b;
        short l = g + m;
        byte d = 25;
        byte e = 22;
        // 编译器会报错
        // byte f=d+e;
        System.out.println("Hello,Docker!");
    }
}
