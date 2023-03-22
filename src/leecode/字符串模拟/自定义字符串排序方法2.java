package leecode.字符串模拟;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/13/11:51
 * @Description:
 */
public class 自定义字符串排序方法2 {
    public static void main(String[] args) {
        String order = "kqep";
        String s = "pekeq";
        String s1 = customSortString(order, s);
        System.out.println(s1);
    }

    //  order = "kqep", s = "pekeq"---》kqeep
    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        // 先去给order中的字符赋以权重，按照出现的顺序依次赋1，2，...
        int[] weight = new int[26];
        for (int i = 0; i < order.length(); i++) {
            weight[order.charAt(i) - 'a'] = i + 1;
        }
        // 把字符串s按照权重进行排序
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (o1, o2) -> weight[o1 - 'a'] - weight[o2 - 'a']);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
