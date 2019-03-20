package filetest;

import java.io.File;

public class ListFileTest {
    public static void main(String[] args) {
        File currentFile = new File(".");  //定义当前上下文路径这个文件夹
        File[] files = currentFile.listFiles();
        for (File file : files) {
            System.out.println(file);  //遍历当前上下文路径的所有文件夹
        }
    }
}
