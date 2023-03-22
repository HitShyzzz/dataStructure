package interview.海康卫视;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/23/22:04
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入发生火灾的楼层：(1-3)");
        int floor=in.nextInt();
        Fire fire1=new Fire(1);
        Fire fire2=new Fire(2);
        Fire fire3=new Fire(3);
        Person person1=new Person(fire1.getFloor());
        Person person2=new Person(fire2.getFloor());
        Person person3=new Person(fire3.getFloor());
        fire1.addObserver(person1);
        fire2.addObserver(person2);
        fire3.addObserver(person3);
        if (floor==1){
            fire1.fire();
        }
        if (floor==2){
            fire2.fire();
        }
        if (floor==3){
            fire3.fire();
        }
    }
}
