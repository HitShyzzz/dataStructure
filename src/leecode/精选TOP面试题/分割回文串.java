package leecode.精选TOP面试题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-27 20:47
 */
public class 分割回文串 {
    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

    static List<List<String>> ans = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;
    }
}
