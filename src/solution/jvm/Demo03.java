package solution.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms 设置初始化内存大小 1/64
 * -Xmx 设置最大分配内存 1/4
 * -XX:+PrintGCDetails 打印GC垃圾回收信息
 * -XX:+HeapOnOutOfMemoryError //oom dump
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/22:41
 * @Description:
 */
public class Demo03 {
    byte[]array=new byte[1<<20];
    public static void main(String[] args) {
        List<Demo03>list=new ArrayList<>();
        int count=0;
        try {
            while (true){
                list.add(new Demo03());
                count++;
            }
        } catch (Error e) {
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }

}
