package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/12:13
 * @Description:
 */
public class 优美的排列II {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int[] array = constructArray(n, k);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    // 差的绝对值是k个不同数，1,2,...n-k差值都是1，然后是 n-k,n,n-k+1,n-1,n-k+2,...这样后面的差值依次是k,k-1,k-2,...1;这样总共就是k个不同的数！
    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            ans[index] = i;
            index++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            ans[index] = i;
            index++;
            if (i != j) {
                ans[index] = j;
                index++;
            }
        }
        return ans;
    }
}
