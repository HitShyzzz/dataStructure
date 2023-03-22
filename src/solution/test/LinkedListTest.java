package solution.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/12/21:32
 * @Description:
 */
public class LinkedListTest {
    public static void main(String[] args) {

        List<Integer>list=Collections.synchronizedList(new LinkedList<>());
        ConcurrentLinkedQueue<Object> objects = new ConcurrentLinkedQueue<>();

    }
}
