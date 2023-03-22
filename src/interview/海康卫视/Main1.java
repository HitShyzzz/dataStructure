package interview.海康卫视;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/23/21:34
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        String s1="hikvision";
        String s2="visionhik";
        boolean check = check(s1, s2);
        System.out.println(check);


    }

    public static boolean check(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if (n1!=n2){
            return false;
        }
        for (int i=0;i<n1-1;i++){
            String s=s1.substring(i+1,n1)+s1.substring(0,i+1);
            if (s.equals(s2)){
                return true;
            }
        }
        return false;
    }
}
