package chapter1.random;

public class TestDemo {
    public static void main(String[] args) {
        /* 获取[0,100)的随机整数 */
        int nextInt = (int) (Math.random() * 100);
    }

    /**
     *获得[0,max)的随机整数
     */
    public static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }

    /**
     * 获得[lo,hi)的随机小数
     *
     * @param lo 随机小数的下限
     * @param hi 随机小数的上限
     * @return 随机生成的小数
     */
    public static double getRandomDouble(double lo, double hi) {
        return Math.random() * (hi - lo) + lo;
    }

    /**
     * 获得[lo,hi)的随机整数
     */
    public static int getRandomInt(int lo, int hi) {
        return getRandomInt(hi - lo) + lo;
    }
}
