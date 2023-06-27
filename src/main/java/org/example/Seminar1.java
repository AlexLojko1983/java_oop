package org.example;


import java.util.Arrays;
import java.util.Random;


public abstract class Seminar1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(2000);// если i= 1 будет деление на ноль
        int n = high_bit_line(i);
        int num_max = Short.MAX_VALUE;
        int num_min = Short.MIN_VALUE;
        int[] m1 = new int[num_max / n];
        int[] m2 = new int[(num_min - i) * -1];
        System.out.println(num_min - i);
        System.out.println(num_min);
        System.out.println(i);
        System.out.println(n);
        System.out.println(Short.MAX_VALUE);
//        int j = 0;
//        int l = 0;
//        if (i > 1) {
//            for (int r = num_min; r < i + 1; r++) {
//                if (r % n != 0) {
//                    m2[l] = r;
//                    l++;
//                }
//            }
//            System.out.println(Arrays.toString(m2));
//            for (int k = i; k < num_max + 1; k++) {
//                if (k % n == 0) {
//                    m1[j] = k;
//                    j++;
//                }
//            }
//            System.out.println(Arrays.toString(m1));
//        } else
//            System.out.println("Деление на ноль");

        int[] new_m1 = M1(m1, i, num_max, n);
        System.out.println(Arrays.toString(new_m1));
        System.out.println(" ");

        int[] new_m2 = M2(m2, i, num_min, n);
        System.out.println(Arrays.toString(new_m2));

    }

    public static int high_bit_line(int x) {
        int res = 0;
        while (x != 1) {
            x >>= 1;
            res++;
        }
        return res;
    }

    public static int[] M1(int[] m1, int i, int num, int n) {

        int j = 0;
        if (i > 1) {
            for (int k = i; k < num + 1; k++) {
                if (k % n == 0) {
                    m1[j] = k;
                    j++;
                }
            }
            return m1;
        } else
            System.out.println("Деление на ноль");

        return m1;

    }

    public static int[] M2(int[] m1, int i, int num, int n) {

        int j = 0;
        if (i > 1) {
            for (int k = num; k < i + 1; k++) {
                if (k % n != 0) {
                    m1[j] = k;
                    j++;
                }
            }
            return m1;
        } else
            System.out.println("Деление на ноль");

        return m1;

    }


}