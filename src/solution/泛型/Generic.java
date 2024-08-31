package solution.泛型;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 10:01
 */
public class Generic<T> {
    private T key;
    public Generic(T key){
        this.key=key;
    }
    public T getKey(){
        return key;
    }
}
