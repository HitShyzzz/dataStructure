package interview.海尔;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/29/16:12
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
       String a="1 2 33 4 -1";
       String[]str=a.split(" ");
        Arrays.sort(str, (o1, o2) -> Integer.parseInt(o1)-Integer.parseInt(o2));
        for(String s:str){
            System.out.print(s+" ");
        }
    }
}
