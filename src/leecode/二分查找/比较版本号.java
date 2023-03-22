package leecode.二分查找;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/05/11:04
 * @Description:
 */
public class 比较版本号 {
    public static void main(String[] args) {
        String version1 = "1.0.0.0";
        String version2 = "1";
        int i = compare(version1, version2);
        System.out.println(i);
    }

    /**
     * 思路：用split函数‘.’隔开依次比较每段数字的大小；
     * 如果遇到哪个version太短了，就直接补0，依次比较；
     * O(T)=O(max(m,n)),m=v1.length;n=v2.length;
     * O(S)=O(max(m,n));
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compare(String version1, String version2) {
        // write code here
        // .是特殊字符，必须加\\转义字符再分割！
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;// 指向version1的指针
        while (i < v1.length || i < v2.length) {
            String s1 = i < v1.length ? v1[i] : "0";
            String s2 = i < v2.length ? v2[i] : "0";
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
