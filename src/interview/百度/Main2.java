package interview.百度;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/15/19:16
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[]str=s.split(" ");
        int n=Integer.parseInt(str[0]);
        int h=Integer.parseInt(str[1]);
        Map<Pair,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s1=in.nextLine();
            String[]ss=s1.split(" ");
            int x=Integer.parseInt(ss[0]);
            int y=Integer.parseInt(ss[1]);
            Pair pair=new Pair(x,y);

        }

    }
}



class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
