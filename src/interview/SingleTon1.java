package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/9:02
 * @Description:
 */
// 懒汉式，线程不安全，
public class SingleTon1 {
    private static SingleTon1 instance;
    private SingleTon1(){

    }
    public static SingleTon1 getInstance(){
        if (instance==null){
            instance=new SingleTon1();
        }
        return instance;
    }
}
