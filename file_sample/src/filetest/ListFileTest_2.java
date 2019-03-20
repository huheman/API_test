package filetest;

import java.io.File;
import java.io.FilenameFilter;

public class ListFileTest_2 {
    public static void main(String[] args) {
        File notExit = new File("notExit"); //定义不存在的文件夹
        File[] filesNotExit = notExit.listFiles();
        System.out.println("filesNotExit = " + filesNotExit);  //filesNotExit = null

        File empty = new File("empty");     //定义空的文件夹
        File[] filesInEmpty = empty.listFiles();
        System.out.println("filesInEmpty.length = " + filesInEmpty.length); //不为null，但filesInEmpty.length = 0

        File file = new File(".idea");
        File[] xmls = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("dir = " + dir);  //dir = .idea
                System.out.println("name = " + name);  //name = encodings.xml
                //过滤器自动帮我们把dir（文件夹）和文件名分开了
                return name.endsWith("xml");
            }
        });
        for (File xml : xmls) {
            System.out.println("xml = " + xml);
        }

        //xml = .idea\encodings.xml
        //xml = .idea\misc.xml
        //xml = .idea\modules.xml
        //xml = .idea\vcs.xml
        //xml = .idea\workspace.xml
    }
}
