package interview;

/**
 * Created with IntelliJ IDEA.
 * 单例模式要点：1.全局只有一个类的实例，至少构造器要私有化。2；单例的类只能有自己创建实例。3；提供public方法来返回实例
 *
 * @Author: shy
 * @Date: 2022/09/01/8:55
 * @Description:
 */
// 饿汉式，静态常量方式，线程安全
public class SingleTon {
    private static SingleTon instance = new SingleTon();

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        return instance;
    }
}
