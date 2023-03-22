package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/9:10
 * @Description:
 */
// 懒汉式，加上了同步锁，线程安全的，但效率有所折扣！
public class SingleTon2 {
    private static SingleTon2 instance;

    private SingleTon2() {

    }

    public static synchronized SingleTon2 getInstance() {
        if (instance == null) {
            instance = new SingleTon2();
        }
        return instance;
    }
}

