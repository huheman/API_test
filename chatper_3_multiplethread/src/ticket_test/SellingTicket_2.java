package ticket_test;

public class SellingTicket_2 implements Runnable {
    private int count = 5;

    @Override
    public void run() {
        while (count > 0) { //只有票数大于0才要卖票
            sellTicket();   //没抢到锁的线程，都只能在这里阻塞。
        }
    }

    private synchronized void sellTicket() {
        if (count > 0) {    //进来以后的线程，还得再判断一次。
            try {
                Thread.sleep(200);
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了一张票，目前还剩" + count + "张");
        }
    }
}
