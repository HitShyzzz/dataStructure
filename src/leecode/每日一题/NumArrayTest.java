package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/13/20:47
 * @Description:
 */
public class NumArrayTest {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        int i = numArray.sumRange(0, 2);
        System.out.println(i);
        numArray.update(1, 2);
        System.out.println(Arrays.toString(numArray.nums));
        i = numArray.sumRange(0, 2);
        System.out.println(i);
    }
}
