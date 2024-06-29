package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 记忆化递归搜索，降低时间复杂度
 * @date: 2024-06-29 21:36
 */
public class 不同的二叉搜索树方法2 {
    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }

    static Map<Integer, Integer> map = new HashMap<>();

    // n个数,1,2,...n组成的二叉搜索树数目
    public static int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            // i-1个数，1,2,...i-1组成的二叉搜索树数目
            int leftNum = numTrees(i - 1);
            // n-i个数,i+1,i+2,...n组成的二叉搜索树数目
            int rightNum = numTrees(n - i);
            // n个数组成的二叉搜索树数目=左子树数目*右子树数目
            int tmp = leftNum * rightNum;
            cnt += tmp;
        }
        map.put(n, cnt);
        return cnt;
    }
}
