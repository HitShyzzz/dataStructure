package interview.海康卫视;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/23/21:47
 * @Description:
 */
public class Fire extends Observable {
    private int floor;// 楼层

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Fire(int floor) {
        this.floor = floor;
    }

    public void fire(){
        System.out.println(floor+"楼发生火灾了，"+ floor+"楼保安快来救火！");
        super.setChanged();
        super.notifyObservers();
    }
}
