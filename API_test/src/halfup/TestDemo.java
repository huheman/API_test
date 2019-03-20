package halfup;

import java.util.stream.IntStream;

public class TestDemo {
    public static void main(String[] args) {
        // 改进版的四舍五入！
        IntStream.generate(() -> ((int) (Math.random() * 20)))  //Math生成随机数
                .limit(11)
                .average()
                .ifPresent(aver-> System.out.printf("%.2f",aver));  //5.73
    }
}
