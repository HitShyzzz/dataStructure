package solution.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/06/8:37
 * @Description:
 */
public class ConditionUseCase {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        public void conditionWait(){
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
        public void conditionSignal(){
            lock.lock();
            try {
                condition.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

}
