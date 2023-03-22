package leecode.字符串模拟;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/06/17:08
 * @Description:
 */
public class 统计子串中的唯一字符 {
    public static void main(String[] args) {
        String s="LEETCODE";
        int i = uniqueLetterString(s);
        System.out.println(i);
    }
    // ABC--->A B C AB BC ABC --->1+1+1+2+2+3=10
    // 先列出所有的子串，再去统计每个子串出现1次的字符数，会超时，s.length<=10^5,光是列出所有的子串都会超时！
    public static int uniqueLetterString(String s) {
        List<String> allSubStrings=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                allSubStrings.add(s.substring(i,j));
            }
        }
        int ans=0;
        for(String key:allSubStrings){
            System.out.print(key+" ");
            int count=0;
            Map<Character,Integer>map=new HashMap<>();
            for(int i=0;i<key.length();i++){
                char c=key.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for(Character i:map.keySet()){
                if (map.get(i)==1){
                    count++;
                }
            }
            ans+=count;
        }
        return ans;
    }
}
