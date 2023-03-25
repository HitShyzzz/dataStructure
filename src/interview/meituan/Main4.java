package interview.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/21:31
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s.length());
        // 输入的字符串要去掉首尾的空格
        String s1 = s.trim();
        System.out.println(s1.length());
        Map<String, String> map = new HashMap<>();
        map.put("123", "456");
        map.put("123", "789");
        System.out.println(map.get("123"));

    }
}
