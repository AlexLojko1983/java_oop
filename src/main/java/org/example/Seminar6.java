package org.example;


import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;


public class Seminar6 {
    public static void main(String[] args) {

        MySet<Integer> myset = new MySet<>();

        System.out.println((myset.add(4165)));
        System.out.println((myset.add(4155565)));
        System.out.println((myset.add(null)));
        System.out.println((myset.add(4165)));
        System.out.println(myset);
        System.out.println((myset.remove(4165)));
        System.out.println(myset.remove(null));
        System.out.println(myset.remove(65456));
        System.out.println(myset);
        Iterator<Integer> iter = myset.iterator();
        while (iter.hasNext()){
            System.out.printf("%d ",iter.next());
        }
    }
}
class MySet<T> {
    private HashMap<T, Object> map = new HashMap<>();
    private static final Object myo = new Object();


    public boolean add(T value) {
        return map.put(value,myo) == null;
    }
    public boolean remove(T value){
        return map.remove(value) == myo;
    }
    public String toString(){
        return map.keySet().toString();
    }
    public Iterator<T> iterator(){
        return map.keySet().iterator();
    }
}