package org.example;

import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.function.Function;


//Задание
//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class Dz_5 {
    public static HashMap book(HashMap<String, List<String>> ponebook, String key, String value) {
        ponebook.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        return ponebook;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, List<String>> ponebook = new HashMap<>();

        ponebook = book(ponebook,"Иванов","4897434");
        ponebook = book(ponebook,"Иванов","68786");
        ponebook = book(ponebook,"Сидоров","4648848");
        ponebook = book(ponebook,"Сидоров","464558848");
        ponebook = book(ponebook,"Сидоров","5");

//        st.sorted(Comparator.comparing(e -> e.getValue()))
//                .forEach(e ->result.put(e.getKey(),e.getValue()));

//        ponebook.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(System.out::println);

        ponebook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size()-o1.size()))
                .forEach(System.out::println);


//        for(HashMap.Entry<String,List<String>> k: ponebook.entrySet()) {
//
//            System.out.println(k.getKey() + ": " + k.getValue());
//        }
    }
}
