package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/16:50
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        String c = "word";
        String d = "word";
        test t1 = new test();
        test t2 = new test();
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(t1 == t2);
    }
}
