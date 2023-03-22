package leecode.每日一题;

import leecode.模拟.买卖股票的最佳时机方法2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/06/10:25
 * @Description:
 */
public class 字符串中不同整数的数目 {
    public static void main(String[] args) {
        String word = "a123bc34d8ef34";
        int i = numDifferentIntegers(word);
        System.out.println(i);
    }

    // word = "a123bc34d8ef34"---》3
    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int p1 = 0;// p1指针指向整数开始的位置
        int p2;// p2指针指向整数结束的下一个位置
        while (true) {
            while (p1 < word.length() && Character.isLetter(word.charAt(p1))) {
                p1++;
            }
            if (p1 == word.length()) {
                break;
            }
            p2 = p1;
            while (p2 < word.length() && Character.isDigit(word.charAt(p2))) {
                p2++;
            }
            // 去掉前导0
            while (p2 - p1 > 1 && word.charAt(p1) == '0') {
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }
}
