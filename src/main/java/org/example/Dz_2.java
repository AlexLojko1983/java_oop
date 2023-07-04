package org.example;


//Задание
//        1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
//        Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dz_2 {

    public static StringBuilder[] pars(String[] line) {
        StringBuilder line_2_1 = new StringBuilder(line[0]);

        line_2_1 = line_2_1.replace(0, line_2_1.lastIndexOf("\"") + 1, "");

        StringBuilder line_2_2 = new StringBuilder(line[1]);
        line_2_2 = line_2_2.replace(0, line_2_2.lastIndexOf("\"") + 1, "");

        StringBuilder line_2_3 = new StringBuilder(line[2]);
        line_2_3 = line_2_3.replace(0, line_2_3.lastIndexOf("\"") + 1, "");

        StringBuilder[] line_0 = new StringBuilder[3];
        line_0[0] = line_2_1;
        line_0[1] = line_2_2;
        line_0[2] = line_2_3;
        return line_0;
    }


    public static void main(String[] args) {
        String line_1 = "SELECT * FROM students WHERE";
        Scanner sc = new Scanner(System.in);

        System.out.printf("name?: ");
        String name = sc.nextLine();
        System.out.printf("country?: ");
        String country = sc.nextLine();
        System.out.printf("city?: ");
        String city = sc.nextLine();
        System.out.printf("age?: ");
        String age = sc.nextLine();

        String sql = String.format("%s name = '%s' AND country = '%s' AND city = '%s' AND age = '%s'", line_1, name,country,city,age);
        String [] a = sql.split("AND ");

        if (name.isEmpty()) {
            StringBuilder bulder = new StringBuilder(a[0]);
            a[0] = bulder.replace(bulder.indexOf("name"), bulder.length(), "").toString();
        }
        if (country.isEmpty()) a[1] = "";
        else if (!a[0].isEmpty()) a[1]= "AND" +" "+ a[1];
        if (city.isEmpty()) a[2]="";
        else if (!a[0].isEmpty() || !a[1].isEmpty()) a[2]= "AND" +" "+ a[2];
        if (age.isEmpty()) a[3] = "";
        else if (!a[0].isEmpty() || !a[1].isEmpty() || !a[2].isEmpty()) a[3]= "AND" +" "+ a[3];

        sql = String.join("",a);

        System.out.println(sql);


//2) Дана json-строка (можно сохранить в файл и читать из файла)
        //        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        //        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        //        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.

        char[] chars = null;
        try {
            File file = new File("file");
            if (!file.exists()) {
                String s = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                FileWriter writer = new FileWriter(file);
                writer.write(s);
                writer.close();
            } else {
                FileReader reader = new FileReader(file);
                chars = new char[(int) file.length()];
                reader.read(chars);
            }
        } catch (IOException e) {
            System.out.println("There is an exception!)");
        }


        String line = String.join("", Arrays.toString(chars));
        line = line.replaceAll("[, ]", "").replace("[", "").replace("]", "").replace("{", "");
        String[] line_2 = line.split("}");
        line_2[3] = "";
        line_2[0] = line_2[0].substring(0, line_2[0].length() - 1);
        line_2[1] = line_2[1].substring(0, line_2[1].length() - 1);
        line_2[2] = line_2[2].substring(0, line_2[2].length() - 1);


        StringBuilder[] line1 = pars(line_2[0].split("\"\""));
        StringBuilder[] line2 = pars(line_2[1].split("\"\""));
        StringBuilder[] line3 = pars(line_2[2].split("\"\""));

        System.out.printf("Студент " + line1[0] + " получил " + line1[1] + " по предмету " + line1[2]);
        System.out.println();
        System.out.printf("Студент " + line2[0] + " получил " + line2[1] + " по предмету " + line2[2]);
        System.out.println();
        System.out.printf("Студент " + line3[0] + " получил " + line3[1] + " по предмету " + line3[2]);
    }
}
