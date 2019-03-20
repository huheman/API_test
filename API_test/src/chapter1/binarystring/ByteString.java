package chapter1.binarystring;

public class ByteString {
    public static void main(String[] args) {
        byte[] bytes = "小鹏头".getBytes();
        int count = 1;
        for (byte aByte : bytes) {
            //System.out.print(":"+Integer.toHexString(aByte)+" ");
            System.out.printf(aByte+":%x   ",aByte);
            if (count++%3==0) {
                System.out.println();
            }
        }
    }
}
