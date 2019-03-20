package chapter2;

import java.io.File;
import java.io.IOException;

public class AbsoluteTest {
    public static void main(String[] args) throws IOException {
        File file_1 = new File("./abc");
        File file_2 = new File("b/../abc");
        /*System.out.println("file_1.getAbsoluteFile() = " + file_1.getAbsoluteFile());
        System.out.println("file_2.getAbsoluteFile() = " + file_2.getAbsoluteFile());
        System.out.println("file_1.getCanonicalFile() = " + file_1.getCanonicalFile());
        System.out.println("file_2.getCanonicalFile() = " + file_2.getCanonicalFile());*/
        File file_1_AbsoluteFile = file_1.getAbsoluteFile();
        File file_2_AbsoluteFile = file_2.getAbsoluteFile();
        File file_1CanonicalFile = file_1.getCanonicalFile();
        File file_2CanonicalFile = file_2.getCanonicalFile();



        System.out.println("file_1CanonicalFile = " + file_1CanonicalFile);
        for (File file : file_1CanonicalFile.listFiles()) {
            System.out.println(file);
        }
        System.out.println("------------");
        System.out.println("file_2CanonicalFile = " + file_2CanonicalFile);
        for (File file : file_2CanonicalFile.listFiles()) {
            System.out.println(file);
        }
        System.out.println("------------");
        System.out.println("file_1_AbsoluteFile = " + file_1_AbsoluteFile);
        for (File file : file_1_AbsoluteFile.listFiles()) {
            System.out.println(file);
        }
        System.out.println("------------");
        System.out.println("file_2_AbsoluteFile = " + file_2_AbsoluteFile);
        for (File file : file_2_AbsoluteFile.listFiles()) {
            System.out.println(file);
        }
    }
}
