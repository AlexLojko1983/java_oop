package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Seminar4 {
    static Scanner scanner;

    static public void sort1(ArrayList<String> ma, ArrayList<String> ms, ArrayList<String> md, ArrayList<Integer> mf, ArrayList<Boolean> mz, ArrayList<Integer> id) {
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return mf.get(o1) - mf.get(o2);
            }

        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(ma.get(id.get(i)) + " " + ms.get(id.get(i)).toUpperCase().charAt(0) + "." + md.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + mf.get(id.get(i)) + " " + (mz.get(id.get(i)) ? "Ж" : "М"));
        }
    }

    static public void sort2(ArrayList<String> ma, ArrayList<String> ms, ArrayList<String> md, ArrayList<Integer> mf, ArrayList<Boolean> mz, ArrayList<Integer> id) {
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (mz.get(o1) == mz.get(o2)) return mf.get(o1) - mf.get(o2);
                return 0;
            }
        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(ma.get(id.get(i)) + " " + ms.get(id.get(i)).toUpperCase().charAt(0) + "." + md.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + mf.get(id.get(i)) + " " + (mz.get(id.get(i)) ? "Ж" : "М"));
        }
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> ma = new ArrayList<>();
        ArrayList<String> ms = new ArrayList<>();
        ArrayList<String> md = new ArrayList<>();
        ArrayList<Integer> mf = new ArrayList<>();
        ArrayList<Boolean> mz = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию -> ");
            ma.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            ms.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            md.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            mf.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            mz.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(mz.size() - 1);
            System.out.println("Продолжить ввод да/нет? -> ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }
        System.out.println(Integer.compare(id.get(0),id.get(1)));
        for (int i = 0; i < ma.size(); i++) {
            System.out.println(ma.get(i) + " " + ms.get(i).toUpperCase().charAt(0) + "." + md.get(i).toUpperCase().charAt(0) + "." + " " + mf.get(i) + " " + (mz.get(i) ? "Ж" : "М"));
        }

//        System.out.println("Сортировать по возрасту да/нет? -> ");
//        String tmp = scanner.nextLine();
//        if (tmp.toLowerCase().contains("да")) sort1(ma, ms, md, mf, mz, id);

        System.out.println("Сортировать по возрасту и полу да/нет? -> ");
        String tmp1 = scanner.nextLine();
        if (tmp1.toLowerCase().contains("да")) sort2(ma, ms, md, mf, mz, id);
    }
}
