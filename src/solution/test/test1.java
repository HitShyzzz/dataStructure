package solution.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/01/11:51
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {
        PriorityQueue<Integer>heap=new PriorityQueue<>();
        heap.offer(1);
        heap.offer(-1);
        heap.offer(0);
        while (!heap.isEmpty()){
            System.out.print(heap.poll()+" ");
        }
        Person person=new Person();
        person.name="张三";
        person.age=23;
        person.salary=10000.00;
        System.out.println("这人是"+person.name+",年龄是"+person.age+"岁"+",收入是"+person.salary);
    }
}
class Person{
    String name;
    int age;
    Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
