package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/15/8:36
 * @Description:
 */
public class 字符串转化后的各位数字之和 {
    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        int lucky = getLucky(s, k);
        System.out.println(lucky);

    }

    // s = "zbax" 且 k = 2
    // 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
    //转换 #1：262124➝ 2 + 6 + 2 + 1 + 2 + 4➝ 17
    //转换 #2：17 ➝ 1 + 7 ➝ 8
    public static int getLucky(String s, int k) {
        // 首先得到整数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            sb.append(num);
        }
        int num = 0;
        String s1 = sb.toString();
        // 再转换k次
        for (int i = 0; i < k; i++) {
            num = 0;
            for (int j = 0; j < s1.length(); j++) {
                num += s1.charAt(j) - '0';
            }
            s1 = num + "";
        }
        return num;
    }
}
