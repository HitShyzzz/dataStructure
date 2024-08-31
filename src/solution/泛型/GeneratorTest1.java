package solution.泛型;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 10:05
 */
public class GeneratorTest1<Integer> implements Generator<java.lang.Integer> {
    @Override
    public java.lang.Integer method() {
        System.out.println("hello world");
        return 1;
    }
}
