package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/05/11:43
 * @Description:
 */
public class 比较版本号方法2 {
    public static void main(String[] args) {
        String version1 = "1.0.0.0";
        String version2 = "1";
        int i = compare(version1, version2);
        System.out.println(i);
    }

    /**
     * 不用split函数，直接用两个指针，分别指向两个字符串，一一去比较.前面数字的大小！
     * 这样做可以把空间复杂度简化到O(1)；
     * O(T)=O(max(m,n)),m=version1.length(),n=version2.length();
     * O(S)=O(1);
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compare(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0;// 指向version1的指针
        int j = 0;// 指向version2的指针
        while (i < n1 || j < n2) {
            int num1 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            // 跳过.
            i++;
            int num2 = 0;
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            // 跳过.
            j++;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
