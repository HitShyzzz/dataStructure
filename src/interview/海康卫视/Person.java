package interview.海康卫视;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/23/21:59
 * @Description:
 */
public class Person implements Observer {
    private int floor;

    public Person(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Fire)o).getFloor()+"楼保安来救火了");
    }
}
