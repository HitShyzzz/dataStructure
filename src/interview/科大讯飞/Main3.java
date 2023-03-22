package interview.科大讯飞;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/20:25
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        String str="iflytekifytek";
        int iflytek = findIflytek(str);
        System.out.println(iflytek);
    }
    public static int findIflytek (String str) {
        // write code here
        //char[]c={'i','f','l','y','t','e','k'};
        String target="iflytek";
        int len=target.length();
        int count=0;
        str.toLowerCase();
        int valid=0;
        for(int i=0;i<str.length();i++){
            if(target.contains(str.substring(i,i+1))&&valid<len){
                valid++;
            }
            if(valid==len){
                count++;
                int k=i;
                int j=i+1;
                valid=0;
                while (k>0&&str.substring(j).contains(str.substring(k,i+1))){
                        count++;
                        valid++;
                         k--;
                }
            }
    }
        return count;
    }
}
