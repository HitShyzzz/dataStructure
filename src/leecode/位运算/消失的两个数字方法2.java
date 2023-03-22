package leecode.位运算;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/26/20:03
 * @Description:
 */
public class 消失的两个数字方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        int[] ints = missingTwo(nums);
        System.out.print(ints[0] + " " + ints[1]);
    }

    public static int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int orRes = 0;// orRes表示把所有的2n-2个数字异或的结果，就是缺少的x和y的异或的结果
        for (int num : nums) {
            orRes ^= num;
        }
        for (int i = 1; i <= n; i++) {
            orRes ^= i;
        }
        // orRes=x^y;orRes必然不为0，我们找出最低位的那个1，设为l位，那么l位x和y必然是不同的；
        int lOperation = orRes & (-orRes);// lOperation表示的是异或结果中最低位的那个1；设为l位；
        // 那么x和y的第l位必然不同，一个是1，一个是0，那么把所有的2n-2个数的第l位进行异或运算，必然会分成两类，
        // 一类l位结果是1，另一类l位结果是0，我们也就找到了缺少的x和y;
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            // 如果
            if ((num & lOperation) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lOperation) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[]{type1, type2};
    }
}
