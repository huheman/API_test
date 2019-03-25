package ticket_test;

public class TestDemo {
    public static void main(String[] args) {
        SellingTicket_3 sellingTicket = new SellingTicket_3();
        new Thread(sellingTicket, "售票员B").start();
        new Thread(sellingTicket, "售票员A").start();
    }
}
