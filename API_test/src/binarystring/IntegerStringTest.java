package binarystring;

public class IntegerStringTest {
    public static void main(String[] args) {
        String str = "你好吗";
        char[] chars = str.toCharArray();
        System.out.println("查看每个字符的2进制：");
        for (char aChar : chars) {
            System.out.println(aChar+" : "+Integer.toBinaryString(aChar));
        }
        System.out.println();
        System.out.println("查看每个字符的16进制码");
        for (char aChar : chars) {
            System.out.println(aChar+" : "+Integer.toHexString(aChar));
        }
    }

}
