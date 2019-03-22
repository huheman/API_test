package baozi_synchronized;

import java.util.Deque;

public class Baker implements Runnable {
    private final Deque<Baozi> baoziDeque;

    public Baker(Deque<Baozi> baoziDeque) {
        this.baoziDeque = baoziDeque;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoziDeque) {
                if (baoziDeque.size() > 5) {
                    System.out.println("包子数大于5个，厨师叫醒了顾客");
                    baoziDeque.notifyAll();
                }
                if (baoziDeque.size() == 10) {
                    System.out.println("有10个包子了，厨师进入了等待");
                    try {
                        baoziDeque.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (baoziDeque.size() < 10) {
                    try {
                        Thread.sleep(100);     //等待1000毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Baozi baozi = new Baozi();
                    baoziDeque.offer(baozi);
                    System.out.println("厨师制作了1个包子" + baozi + "，现在有包子" + baoziDeque.size() + '个');
                }
            }
        }
    }
}
