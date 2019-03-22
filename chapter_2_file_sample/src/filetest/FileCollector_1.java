package filetest;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
 * 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
 *
 * 用个数作为value,放入到map集合中,并用两种方式遍历map集合
 */
public class FileCollector_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入文件路径：");
            String fileName = scanner.nextLine();
            Set<File> allFiles = FileWalker.walk(fileName);
            //根据文件后缀名分类：
            Map<String, List<File>> collect = allFiles.parallelStream().collect(Collectors.groupingBy(file -> {
                String name = file.getName();
                int index = name.lastIndexOf(".");
                if (index>0) return name.substring(index);
                return "unknown";
            }, Collectors.toList()));
            //打印各类文件集合的数量和名称：
            for (Map.Entry<String, List<File>> entry : collect.entrySet()) {
                System.out.println(entry.getKey() + " : "+entry.getValue().size());
                for (File file : entry.getValue()) {
                    System.out.println(file);
                }
            }
        }
    }
}
