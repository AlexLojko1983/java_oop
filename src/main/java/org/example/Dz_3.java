package org.example;

//Задание:
//        Пусть дан произвольный список целых чисел.
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

import java.lang.reflect.Array;
import java.util.*;

public class Dz_3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list_even = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(50));
        }
        System.out.println(list);


//1) Нужно удалить из него чётные числа
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            if (i % 2 != 0) {
                list_even.add(i);
            }
        }
        System.out.println(list_even);

//        2) Найти минимальное значение

        System.out.println(Collections.min(list));

        int minimum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minimum > list.get(i))
                minimum = list.get(i);
        }
        System.out.println("Minimum element in ArrayList = "
                + minimum);


//        3) Найти максимальное значение

        System.out.println(Collections.max(list));

        int maximum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (maximum < list.get(i))
                maximum = list.get(i);
        }
        System.out.println("Maximum element in ArrayList = "
                + maximum);

//        4) Найти среднее значение
        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
        double avr = sum/list.size();
        System.out.println(avr);


    }
}
