package filetest;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * 获得指定文件夹下所有的java文件(不考虑子文件夹的)并输出到控制台
 */
public class FileWalker {
    public static void main(String[] args) {
        Set<File> walk = walk("..",".*\\.java");
        for (File file : Objects.requireNonNull(walk)) {
            System.out.println(file);
        }
    }

    public static Set<File> walk(File file, Predicate<File> predicate) {
        if (!file.exists()) return null;
        HashSet<File> fileHashSet = new HashSet<>();
        if (file.isFile()) {
            if (predicate.test(file)) fileHashSet.add(file);
        } else {
            File[] files = file.listFiles(f -> f.isDirectory() || predicate.test(f));
            if (files==null) return fileHashSet;
            for (File fileListed : Objects.requireNonNull(files)) {
                fileHashSet.addAll(Objects.requireNonNull(walk(fileListed, predicate)));
            }
        }
        return fileHashSet;
    }

    public static Set<File> walk(File file) {
        return walk(file, ".*");
    }

    public static Set<File> walk(File file, String pattern) {
        return walk(file, f -> Pattern.matches(pattern, f.getName()));
    }

    public static Set<File> walk(String pathName) {
        return walk(new File(pathName));
    }

    public static Set<File> walk(String pathName, String pattern) {
        return walk(new File(pathName), pattern);
    }
}

