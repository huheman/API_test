package chapter2;

import java.io.File;

/**
 * 3种不同类型的file对象在调用getAbsoluteFile()时的不同结果
 */
public class FileTypeTest {
    public static void main(String[] args) {
        //第一种类型
        File type_1 = new File("ok.txt");
        System.out.println("type_1.getAbsoluteFile() = " + type_1.getAbsoluteFile());
        // D:\IdeaProjects\Blog\ok.txt   获得的是上下文路径+当前路径的强行拼接

        //第二种类型
        File type_2 = new File("/ok.txt");
        System.out.println("type_2.getAbsoluteFile() = " + type_2.getAbsoluteFile());
        //D:\ok.txt   盘符+当前路径

        //第三种类型
        File type_3 = new File("D:/ok.txt");
        System.out.println("type_3.getAbsoluteFile() = " + type_3.getAbsoluteFile());
        //D:\ok.txt   文件本身
    }
}
