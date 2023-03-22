package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/11/8:22
 * @Description:
 */
public class 字母与数字 {

    // 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
    //
    //输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
    public String[] findLongestSubarray(String[] array) {
        String[] ans = new String[]{};
        int n = array.length;
        int[] letter = new int[n];
        letter[0] = (Character.isLetter(array[0].charAt(0)) ? 1 : 0);
        int[] num = new int[n];
        num[0] = (Character.isDigit(array[0].charAt(0)) ? 1 : 0);
        for (int i = 1; i < n; i++) {
            letter[i] = letter[i - 1];
            num[i] = num[i - 1];
            if (Character.isLetter(array[i].charAt(0))) {
                letter[i]++;
            } else {
                num[i]++;
            }
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int letterCount = letter[i] - letter[j];
                int NumCount = num[i] - num[j];
                if (Character.isLetter(array[j].charAt(0))) {
                    letterCount++;
                } else {
                    NumCount++;
                }
                if (letterCount == NumCount && ((i - j + 1) > maxLen)) {
                    maxLen = i - j + 1;
                    ans = Arrays.copyOfRange(array, j, i + 1);
                }
            }
        }
        return ans;
    }
}
