package solution;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 9:45
 */
public class Exception {
    public static void main(String[] args) {
        try {
            System.out.println("Try To Do Something!");
            throw new RuntimeException("RuntimeException123");
        } catch (java.lang.Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }
    }
}
