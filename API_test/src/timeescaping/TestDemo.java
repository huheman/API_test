package timeescaping;

import java.util.stream.IntStream;

public class TestDemo {
    public static void main(String[] args) {
        /* 新建一个任务：用foreach方式遍历一个数组 */
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TodoList one = () -> {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
        };
        /* 新建一个：用Stream方式遍历一个数组 */
        TodoList two = () -> IntStream.of(ints).forEach(n-> System.out.print(n+","));
        //分别测试各个耗时：
        System.out.println("任务一");
        testInNano(one);
        System.out.println("任务二");
        testInNano(two);

        System.out.println("任务一：");
        testInMillion(one);
        System.out.println("任务二：");
        testInMillion(two);
    }

    public static void testInMillion(TodoList todoList) {
        long begin = System.currentTimeMillis();
        todoList.doSomething();
        System.out.println("以毫秒为单位的测试：" + (System.currentTimeMillis() - begin));
    }

    public static void testInNano(TodoList todoList) {
        long begin = System.nanoTime();
        todoList.doSomething();
        System.out.println("以纳秒为单位的测试：" + (System.nanoTime() - begin));
    }
}

