package baozi_synchronized;

import java.util.Deque;

public class Customer implements Runnable {
    private final Deque<Baozi> baoziDeque;

    public Customer(Deque<Baozi> baoziDeque) {
        this.baoziDeque = baoziDeque;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoziDeque) {
                if (baoziDeque.size() < 5) {
                    System.out.println("包子数小于5个了，顾客叫醒厨师");
                    baoziDeque.notifyAll();
                }
                if (baoziDeque.size() == 0) {
                    System.out.println("包子数为0个，顾客进入了等待");
                    try {
                        baoziDeque.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (baoziDeque.size() > 0) {
                    try {
                        Thread.sleep(100);     //等待1000毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Baozi baozi = baoziDeque.poll();
                    System.out.println("顾客吃掉了包子" + baozi + ",现在还剩" + baoziDeque.size() + "个包子");
                }
            }
        }
    }
}
