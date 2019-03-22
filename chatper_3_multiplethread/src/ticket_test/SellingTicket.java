package ticket_test;

public class SellingTicket implements Runnable {
    private int count = 100;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (this) {
                if (count > 0) {
                    try {
                        Thread.sleep(((int) (Math.random() * 10+10)));  //睡10~20毫秒模拟售票耗时
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(name + "卖出了一张票，" +
                            "目前还有票" + count + "张");

                } else {
                    System.out.println(name + "发现票卖完了！下班！");
                    break;
                }
            }
        }
    }
}
