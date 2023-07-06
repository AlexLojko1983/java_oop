package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Seminar4 {
    static Scanner scanner;

    static public void sortage(ArrayList<String> name, ArrayList<String> lastname, ArrayList<String> surname, ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return age.get(o1) - age.get(o2);
            }

        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(name.get(id.get(i)) + " " + lastname.get(id.get(i)).toUpperCase().charAt(0) + "." + surname.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i)) ? "Ж" : "М"));
        }
    }

    static public void sortgenderage(ArrayList<String> name, ArrayList<String> lastname, ArrayList<String> surname, ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1)==true) return 1;
                else return -1;
            }

        });
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1) == gender.get(o2)) return age.get(o1) - age.get(o2);
                return 0;
            }
        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(name.get(id.get(i)) + " " + lastname.get(id.get(i)).toUpperCase().charAt(0) + "." + surname.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i)) ? "Ж" : "М"));
        }
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> lastname = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию -> ");
            name.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            lastname.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            surname.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            gender.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(gender.size() - 1);
            System.out.println("Продолжить ввод да/нет? -> ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }

        System.out.println(id);
        System.out.println(Integer.compare(id.get(0),id.get(1)));



        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " " + lastname.get(i).toUpperCase().charAt(0) + "." + surname.get(i).toUpperCase().charAt(0) + "." + " " + age.get(i) + " " + (gender.get(i) ? "Ж" : "М"));
        }

        System.out.println("Сортировать по возрасту да/нет? -> ");
        String tmp = scanner.nextLine();
        if (tmp.toLowerCase().contains("да")) sortage(name, lastname, surname, age, gender, id);

        System.out.println("Сортировать по возрасту и полу да/нет? -> ");
        String tmp1 = scanner.nextLine();
        if (tmp1.toLowerCase().contains("да")) sortgenderage(name, lastname, surname, age, gender, id);
    }
}
