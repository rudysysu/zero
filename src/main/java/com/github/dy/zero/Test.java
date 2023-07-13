package com.github.dy.zero;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String folder = "/Users/dingyong02/Documents/05 Learning/Coursera斯坦福大学机器学习2014/斯坦福大学机器学习/Season 01";
        final File[] files = new File(folder).listFiles();

        for (File file: files) {
            if (file.isFile()) {
                String name = file.getName();
                name = name.replaceAll(" .*", ".mkv");
                System.out.println(name);
                file.renameTo(new File(folder + "/" + name));
            }

        }


        // for (File file: files) {
        //     String name = file.getName();
        //     name = name.replaceFirst("\\.", " ");
        //     // System.out.println(name);
        //     name = name.replaceFirst("\\.", " ");
        //     System.out.println(name);
        //     file.renameTo(new File(folder + "/" + name));
        // }

        // for (File file: files) {
        //     String name = file.getName();
        //
        //     name = name.replaceFirst(" - ", "E0");
        //     //System.out.println(name);
        //
        //     if (name.indexOf("E") == 1) {
        //         name = "S0" + name;
        //     } else {
        //         name = "S" + name;
        //     }
        //     // System.out.println(name);
        //
        //     name = name.replaceFirst(" - ", ".");
        //     // System.out.println(name);
        //
        //     name = "斯坦福大学机器学习." + name;
        //     System.out.println(name);
        //
        //     file.renameTo(new File(folder + "/" + name));
        // }

    }
}
