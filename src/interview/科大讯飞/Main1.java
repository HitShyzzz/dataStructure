package interview.科大讯飞;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/19:53
 * @Description:
 */
public class Main1 {
    public int findEwordCount (String string) {
        // write code here
        String[] s = string.split(" ");
        int count=0;
        for(int i=0;i<s.length;i++){
            String cur=s[i];
            if(cur.contains("e")){
                count++;
            }
        }
        return count;
    }
}
