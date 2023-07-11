package org.example;

import java.io.IOException;
import java.util.*;

public class Dz_5 {
    static class DupliMap extends HashMap<String, List<String>> {
        DupliMap(String... objects) throws IOException {
            super();

            if (objects.length % 2 != 0) throw new IOException("Failure odd number of parameters to be entered");

            for (int i = 0; i < objects.length; i += 2) this.ponebook(objects[i], objects[i + 1]);
        }

        DupliMap ponebook(String key, String value) {
            this.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

            return this;
        }
        static class addvalue {

        }

        void print() { System.out.println(this); }
    }




    public static void main(String[] args) throws IOException {
        HashMap<String, String> ponebook = new HashMap<>();


        ponebook.put("Иванов", String.valueOf("4621876"));
        ponebook.put("Иванов", String.valueOf("4897434"));

        new  DupliMap("Иванов", "4621876","Иванов", "4897434").print();

//        for(HashMap.Entry<String,String> k: ponebook.entrySet()) {
//            System.out.println(k.getValue() + ": " + k.getKey());
//        }
    }
}
