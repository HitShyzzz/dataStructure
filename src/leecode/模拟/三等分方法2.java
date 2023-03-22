package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/06/19:55
 * @Description:
 */
public class 三等分方法2 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int[] ints = threeEqualParts(arr);
        System.out.print(ints[0] + " " + ints[1]);
    }

    // 将数组中的1三等分，如果能三等分，那么每一部分的1的数量必然是相同的。
    public static int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int sum = 0;// 统计数组中1的数量
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                sum++;
            }
        }
        if (sum % 3 != 0) {// 如果1的数量不能被3整除，那么一定不能三等分
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        int partial = sum / 3;
        // first表示第1段中第1个1出现的位置下标，second表示第2段中第1个1出现的位置下标，third表示第3段中第1个1
        // 出现的位置下标，cur表示当前是第几个1；
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }
        int len = n - third;// 表示每段的数量，因为我们把0都归到了每一段1的后面，因此每一段的长度必然是相等的，
        // 都==len;
        if (first + len <= second && second + len <= third) {
            for (int i = 0; i + third < n; i++) {
                // 我们找到每段的第一个1，那么每一段剩下的每一位数字都必须完全相同，否则就找不到；
                if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}
