package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/9:24
 * @Description:
 */
public class 最大交换方法2 {
    // 2736---》7632---》交换2和7---》7236.
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int len = charArray.length;
        int maxNum = num;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);// 避免这次操作对下次产生影响
            }
        }
        return maxNum;
    }

    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
