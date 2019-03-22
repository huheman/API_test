package baozi_synchronized;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class TestDemo {
    public static void main(String[] args) {
        Deque<Baozi> baoziDeque = new LinkedBlockingDeque<>();
        for (int i = 0; i < 5; i++) {
            baoziDeque.add(new Baozi());    //先放几个包子到序列中
        }
        Baker baker = new Baker(baoziDeque);
        Customer customer = new Customer(baoziDeque);
        new Thread(baker).start();
        new Thread(customer).start();
    }
}
