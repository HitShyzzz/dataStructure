package solution.抽象类;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/04/11:16
 * @Description:
 */
public interface TestInterface {
       int age=18;
       public  default int say(){
           System.out.println("hello,kunkun!");
           return 0;
       }
}
