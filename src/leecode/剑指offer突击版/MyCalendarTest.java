package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/10:06
 * @Description:
 */
public class MyCalendarTest {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        boolean b1 = myCalendar.book(47, 50);
        boolean b2 = myCalendar.book(33, 41);
        boolean b3 = myCalendar.book(39, 45);
        boolean b4 = myCalendar.book(33, 42);
        boolean b5 = myCalendar.book(25, 32);
        boolean b6 = myCalendar.book(26, 35);
        boolean b7 = myCalendar.book(19, 25);
        boolean b8 = myCalendar.book(3, 8);
        boolean b9 = myCalendar.book(8, 13);
        boolean b10 = myCalendar.book(18, 27);
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);
//        System.out.println(b4);
        for(int[] i :myCalendar.list){
            System.out.print(i[0]+" "+i[1]);
            System.out.println();
        }
        System.out.println(b10);

    }
}
