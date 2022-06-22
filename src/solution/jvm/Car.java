package solution.jvm;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/21/20:52
 * @Description:
 */
public class Car {
    public static void main(String[] args) throws AWTException {
        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        System.out.println(aClass);
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        Robot robot = new Robot();
    }
}
