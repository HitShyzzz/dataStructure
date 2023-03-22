package interview.中兴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/24/20:02
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String str[]=s.split(" ");
        int n=str.length;
        List<int[]>list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if (str[i].contains(",")) {
                String[] s1 = str[i].split(",");
                list.add(new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])});
            }
        }
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if((list.get(i)[0]<=list.get(j)[0]&&list.get(i)[1]>=list.get(j)[1])||(list.get(i)[0]>=list.get(j)[0]&&list.get(i)[1]<=list.get(j)[1])){
                    n--;
                }
            }
        }
        System.out.println(n);
    }
}
