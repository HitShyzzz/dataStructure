package solution;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/25/19:06
 * @Description:
 */
public class 巡回置换 {
    public static void main(String[] args) {
        int[] p = {4, 7, 3, 2, 1, 5, 6};
        int x;
        for (int k = 1; k <= 7; k++) {
            x = k;
            System.out.println("k=" + k);
            do {
                System.out.print(x + " ");
                x = p[x - 1];
            } while (x != k);
            System.out.println();
        }
    }
}
