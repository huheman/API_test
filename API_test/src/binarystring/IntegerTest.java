package binarystring;

public class IntegerTest {
    public static void main(String[] args) {
        testInt();
        System.out.println("---------");
        testChar();
    }

    public static void testInt() {
        System.out.println("Integer.toBinaryString(30) = " + Integer.toBinaryString(30));
        System.out.println("Integer.toHexString(30) = " + Integer.toHexString(30));
        System.out.println("Integer.toOctalString(30) = " + Integer.toOctalString(30));
    }

    public static void testChar() {
        System.out.println("Integer.toBinaryString('b') = " + Integer.toBinaryString('b'));
        System.out.println("Integer.toHexString('b') = " + Integer.toHexString('b'));
        System.out.println("Integer.toOctalString('b') = " + Integer.toOctalString('b'));
    }
}
