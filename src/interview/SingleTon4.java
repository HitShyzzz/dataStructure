package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/9:16
 * @Description:
 */
// 静态内部类实现单例模式
public class SingleTon4 {
    private static class SingleTonHolder {
        private static final SingleTon4 instance = new SingleTon4();
    }

    private SingleTon4() {

    }

    public static final SingleTon4 getInstance() {
        return SingleTonHolder.instance;
    }
}

