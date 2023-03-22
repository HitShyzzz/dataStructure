package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/9:12
 * @Description:
 */
// 双重检验锁，线程安全！
public class SingleTon3 {
    private volatile static SingleTon3 instance;

    private SingleTon3() {

    }

    public static SingleTon3 getInstance() {
        if (instance == null) {
            synchronized (SingleTon3.class) {
                if (instance == null) {
                    instance = new SingleTon3();
                }
            }
        }
        return instance;
    }
}
