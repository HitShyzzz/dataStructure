package interview;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/16:50
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        TreeSet<Integer>set=new TreeSet<>();
        set.add(3);
        set.add(10);
        set.add(1);
        Iterator<Integer>iterator= set.descendingIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
