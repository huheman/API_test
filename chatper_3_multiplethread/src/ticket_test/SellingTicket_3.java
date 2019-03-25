package ticket_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellingTicket_3 implements Runnable{
    private int count=5;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (count > 0) {
                    Thread.sleep(1000);
                    count--;
                    System.out.println(Thread.currentThread().getName()+"卖出了1张票，现在还有票"+count+"张");
                }else {
                    System.out.println(Thread.currentThread().getName() + "发现票卖光啦，下班！");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
