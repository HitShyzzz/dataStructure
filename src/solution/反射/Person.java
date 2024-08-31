package solution.反射;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/04/10:14
 * @Description:
 */
public class Person implements Comparable<Person> {
    //私有属性
    private String name;
    //公有属性
    public int age;

    //构造方法
    public Person() {
    }

    public Person(int age){
        this.age=age;
    }

    public Person(String name){
        this.name=name;
    }

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    //私有方法
    private void say() {
        System.out.println("private say()...");
    }

    //公有方法
    public void work() {
        System.out.println("public work()...");
    }

    @Override
    public int compareTo(Person o) {
        if (this.age>o.age){
            return 1;
        } else if (this.age==o.age) {
            return 0;
        }
        return -1;
    }
}
