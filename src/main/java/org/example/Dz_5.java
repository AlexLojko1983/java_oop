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

        ponebook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size()-o1.size()))
                .forEach(System.out::println);
    }
}

//    static HashMap<String, String> map;
//
//    public static void main(String[] args) {
//        map = new HashMap<>();
//
//        map.merge("Petr", "123", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Petr", "234", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Petr", "345", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Petr", "456", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Petr", "567", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Ivan", "123", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Ivan", "234", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Ivan", "345", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Olga", "456", (ov, nv) -> ov==null?nv:ov+" "+nv);
//        map.merge("Olga", "567", (ov, nv) -> ov==null?nv:ov+" "+nv);
//
//
////        addNumber("Petr", "123");
////        addNumber("Petr", "234");
////        addNumber("Petr", "567");
////        addNumber("Petr", "890");
////        addNumber("Ivan", "123");
////        addNumber("Ivan", "234");
////        addNumber("Ivan", "456");
////        addNumber("Olga", "789");
//
//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.split(" ").length - o1.split(" ").length))
//                .forEach(System.out::println);
//
//        System.out.println(map);
////
////        map.put("Petr", Arrays.asList("234", "345"));
////        map.put("Pedtr", List.of("345", "347", "567"));
////        map.get("Petr").add("456");
//
//    }
//
////    private static void addNumber(String name, String number){
////        map.putIfAbsent(name, new ArrayList<>());
////        map.get(name).add(number);
////    }
//
//
//}