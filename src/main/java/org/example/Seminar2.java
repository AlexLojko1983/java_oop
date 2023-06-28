package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Seminar2 {
    Comparator<Integer> comparator;
    Iterator<Integer> iterator;

    public static void main(String[] args) {

        char[] chars = null;
        try {
            File file = new File("file");
            if (!file.exists()) {
                String s = "Abra kadabra !!  ";
                FileWriter writer = new FileWriter(file);
                writer.write(s);
                writer.append("!@\n");
                writer.close();
            } else {
                FileReader reader = new FileReader(file);
                chars = new char[(int) file.length()];
                reader.read(chars);
            }
        } catch (IOException e) {
            System.out.println("There is an exception!)");
        }
        System.out.println(Arrays.toString(chars));
        System.out.println(chars);
//        String ss = String.join("", chars);
//        System.out.println(ss);

        String s = "Hi!";
        System.out.printf("%s!", s);
        System.out.println(" ");
        if (s.contains("Hi"))
            System.out.println(s.repeat(7));
        System.out.println(s + (1 + 4));
        s = "Иванов., Матвей, Иосифович.";
        System.out.println(s.toLowerCase().charAt(3));
        System.out.println(s.substring(3, 9));
        if (s.equals("H"));// Сравнение переменных (== сравнение ссылок)
        System.out.println(s.indexOf("а"));
        System.out.println(s.lastIndexOf('о'));
//        s = s.replace(",", " ");
//        s = s.replace(",", "");
//        s = s.replace(".,", "");
        s = s.replaceAll("[.,]", "");
        System.out.println(s);
        String[] a = s.split(" ");
        System.out.println(a[0] + " " + a[1].toUpperCase().charAt(0) + "." + a[2].toUpperCase().charAt(0) + ".");

        StringBuilder builder = new StringBuilder("jhgf");
        builder.append("!");
        builder.indexOf("7", 6);
        builder.reverse();
        s=builder.toString();
        System.out.println(s);
        builder.replace(1, 3, "f");
        s = builder.toString();
        System.out.println(s);

//                String s1 = "";
//                long start = System.currentTimeMillis();
//                for (int i = 0; i < 1000; i++) {
//                    s1 += Character.getName(i);
//                }
//                System.out.println("String time:" + (System.currentTimeMillis() - start));
//
//                StringBuilder builder1 = new StringBuilder("");start = System.currentTimeMillis();
//                for (int i = 0; i < 1000; i++) {
//                    builder1.append(Character.getName(i));
//                }
//                System.out.println("String time:" + (System.currentTimeMillis() - start));

    }

}

