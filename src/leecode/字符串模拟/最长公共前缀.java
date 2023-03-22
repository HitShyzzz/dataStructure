package leecode.字符串模拟;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/25/16:56
 * @Description:
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        String[]strs={"abca","abc","abca","abc","abcc"};
       // Arrays.sort(strs);
        for(String s:strs){
            System.out.print(s+" ");
        }
        System.out.println(longestCommonPrefix(strs));
    }
    // 纵向扫描
    public static String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs==null||strs.length==0){
            return "";
        }
        int n=strs.length;
        int rows=n;
        int cols=strs[0].length();
        for(int i=0;i<cols;i++){
            char compareChar=strs[0].charAt(i);
            for(int j=1;j<rows;j++){
                // strs[j].length()==i这个条件是说如果有的字符串的长度就等于最长的公共前缀的长度，那么这个时候也要截取输出；
                // 避免发生数组越界！
              if(strs[j].length()==i|| strs[j].charAt(i)!=compareChar){
                  return strs[0].substring(0,i);
              }
            }
        }
        return strs[0];
    }
}
