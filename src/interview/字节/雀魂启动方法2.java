package interview.字节;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/16/10:40
 * @Description:
 */
public class 雀魂启动方法2 {
    private static boolean pass(boolean hadHeader, int count, int[] poker) {
        if (count == 0) {
            return true;
        }
        if (hadHeader) {
            for (int i = 0; i < 9; i++) {
                if (poker[i] > 2) {
                    poker[i] -= 3;
                    if (pass(true, count - 3, poker)) {
                        return true;
                    }
                    poker[i] += 3;
                }
                if (i < 7 && poker[i] > 0 && poker[i + 1] > 0 && poker[i + 2] > 0) {
                    poker[i]--;
                    poker[i + 1]--;
                    poker[i + 2]--;
                    if (pass(true, count - 3, poker)) {
                        return true;
                    }
                    poker[i]++;
                    poker[i + 1]++;
                    poker[i + 2]++;
                }
            }
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (poker[i] > 1) {
                    poker[i] -= 2;
                    if (pass(true, count - 2, poker)) {
                        return true;
                    }
                    poker[i] += 2;
                }
            }
            return false;
        }
    }

    private static void copyArray(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < 9; i++) {
            arrayA[i] = arrayB[i];
        }
    }

    public static void main(String[] args) {
        /*
         * enter data to int array poker
         */
        StringBuffer result = new StringBuffer();
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int[] poker = new int[9], pokerBackup = new int[9];
        for (int i = 0; i < 13; i++) {
            poker[Integer.parseInt(temp[i]) - 1]++;
        }

        for (int i = 0; i < 9; i++) {
            copyArray(pokerBackup, poker);
            if (poker[i] < 4) {
                poker[i]++;
                if (pass(false, 14, poker)) {
                    if (result.length() != 0) {
                        result.append(" ");
                    }
                    result.append(String.valueOf(i + 1));
                }
                poker[i]--;
            }
            copyArray(poker, pokerBackup);
        }

        if (result.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(result.toString());
        }
    }
}
