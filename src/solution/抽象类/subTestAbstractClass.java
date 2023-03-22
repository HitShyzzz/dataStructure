package solution.抽象类;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/04/11:25
 * @Description:
 */
public class subTestAbstractClass extends TestAbstractClass{
    public static void main(String[] args) {
        subTestAbstractClass subTestAbstractClass = new subTestAbstractClass();
        subTestAbstractClass.dance();
    }
    @Override
    public void dance() {
        age=17;
        System.out.println("我家坤坤"+age+"岁！");
        System.out.println("我家坤坤会跳舞！");
    }
}
