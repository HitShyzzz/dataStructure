package leecode.字符串模拟;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/02/23:01
 * @Description:
 */
public class 串联所有单词的子串 {
    public static void main(String[] args) {
        String s ="lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        List<Integer> list = findSubstring(s, words);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        int len = m * n;
        if (s.length() < len) {
            return list;
        }
        Map<String,Integer>have=new HashMap<>();
        for(int i=0;i<n;i++){
            have.put(words[i],have.getOrDefault(words[i],0)+1);
        }
        for (int i = 0; i <= s.length()-len; i++) {
            Map<String,Integer>need=new HashMap<>();
            int valid=0;
            for (int j = i; j < i + len; j = j + m) {
                    String temp = s.substring(j, j + m);
                    if(have.containsKey(temp)){
                        need.put(temp,need.getOrDefault(temp,0)+1);
                        if (need.get(temp)<=have.get(temp)){
                            valid++;
                        }
                    } else {
                        break;
                    }
            }
            if (valid == n) {
                list.add(i);
            }
        }
        return list;
    }
}
