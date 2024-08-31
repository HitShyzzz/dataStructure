package solution.反射;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/04/10:10
 * @Description:
 */
public class testReflection implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        // 18
        System.out.println(person.age);
        Class p1 = person.getClass();
        Field age = p1.getDeclaredField("age");
        System.out.println(age);
        age.setAccessible(true);
        age.set(person, 19);
        // 19
        System.out.println(person.age);
        System.out.println(age);
        Method[] methods = p1.getMethods();
        for (Method method : methods) {
            System.out.println(methods);
        }
        Field[] fields = p1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Class p2 = Person.class;
        System.out.println(p2.getMethods());
        System.out.println(p2.getFields());
        Class p3 = Class.forName("solution.反射.Person");
        System.out.println(p3.getMethods());
        System.out.println(p3.getFields());
        System.out.println(p1 == p2);
        System.out.println(p2 == p3);
    }

}
