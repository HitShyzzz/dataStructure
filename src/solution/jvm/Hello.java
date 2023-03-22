package solution.jvm;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/21:58
 * @Description:
 */
public class Hello {
    public static void main(String[] args) {
        String s="kuangshensayJava";
        while (true){
            s+=s+new Random().nextInt(88888888)+new Random().nextInt(99999999);
        }
    }
}
