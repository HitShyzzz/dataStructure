package solution.泛型;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 10:03
 */
public class GenericTest {
    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<Integer>(1);
        System.out.println(generic.getKey());
    }
}
