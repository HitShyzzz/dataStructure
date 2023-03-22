package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/25/16:00
 * @Description:
 */
public class 字符串变形 {
    public String trans(String s, int n) {
        // write code here
        String[] str = s.split(" ", -1);// -1表示该模式可以使用无限多次，那么单词之间的多个空格也都会保留下来!
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
           String s1=str[i];
           for(int j=0;j<s1.length();j++){
               char c=s1.charAt(j);
               c=Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c);
               sb.append(c);
           }
           if(i!=0){
               sb.append(" ");
           }
        }
        return sb.toString();
    }
}
