package solution;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/14/18:45
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) {
        String s="cba";
        char[]c=s.toCharArray();
        Arrays.sort(c);
        String str=String.valueOf(c);
        System.out.println(str);
        System.out.println("你好！");
        Date date=new Date();
        System.out.println(new Date());
    }
}
