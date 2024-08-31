package solution.多线程;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 21:34
 */
public class SingleTon {
    private volatile static SingleTon uniqueInstance;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingleTon.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }

}
