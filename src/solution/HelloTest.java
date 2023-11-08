package solution;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/9:29
 * @Description:
 */
public class HelloTest {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 11; i *= 2) {
            for (int j = 1; j <= i; j++) {
                count++;
            }
        }
        System.out.println(count);
    }
}
