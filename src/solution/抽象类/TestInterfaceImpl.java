package solution.抽象类;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/04/11:17
 * @Description:
 */
public class TestInterfaceImpl implements TestInterface{
    public static void main(String[] args) {
        System.out.println(age);
        TestInterfaceImpl testInterface = new TestInterfaceImpl();
        testInterface.test(age);
    }

    public  void test(int age){
        age=17;
        this.say();
    }

}
