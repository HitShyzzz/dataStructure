package solution.泛型;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/10:35
 * @Description:
 */
public class 泛型类 {

}

class Box<T>{
    private T t;
    public void add(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }
}
