package org.example;

interface VendingMachine {
    void getProduct(String name, int volume);
    void getProduct(String name, int volume, int temperature);
}

class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public void getInfo() {
        System.out.println("Название: " + name);
        System.out.println("Объём: " + volume + " мл");
    }
}

class HotDrinkHeir extends HotDrink {
    private int temperature;

    public HotDrinkHeir(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Температура: " + temperature + " градусов");
    }
}

class HotDrinkMachine implements VendingMachine {
    @Override
    public void getProduct(String name, int volume) {
        System.out.printf("Выдан продукт по имени " + name + "  и объёму " + volume);
        System.out.println();
    }

    @Override
    public void getProduct(String name, int volume, int temperature) {
        System.out.printf("Выдан продукт по имени " + name + "  и объёму " + volume + " и температуре " + temperature);
        System.out.println();
    }
}

public class oop_dz_1 {
    public static void main(String[] args) {
        HotDrink напиток1 = new HotDrink("Чай", 200);
        HotDrinkHeir напиток2 = new HotDrinkHeir("Кофе", 150, 90);

        HotDrinkMachine автомат = new HotDrinkMachine();

        напиток1.getInfo();
        напиток2.getInfo();

        автомат.getProduct("Чай", 200);
        автомат.getProduct("Кофе", 150, 90);
    }
}

