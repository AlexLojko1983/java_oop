package org.example;

import java.util.ArrayList;
import java.util.List;

interface PeopleBehaviour {
    void setMakeOrder();

    void setTakeOrder();

    boolean isMakeOrder = false;
    boolean isTakeOrder = false;
}

interface QueueBehaviour {
    void takeInQueue(People people);

    void takeOrders(People people);

    void giveOrders(People people);

    void releaseFromQueue(People people);
}

interface MarketBehaviour {
    void acceptToMarket(People people);

    void releaseFromMarket(List<People> queue);

    void update();

}


abstract class People implements PeopleBehaviour {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public People(String name) {
        this.name = name;
//        isMakeOrder = false;
//        isTakeOrder = false;
    }

    public String getName() {
        return name;
    }

//    public abstract void setMakeOrder(boolean isMakeOrder);
//
//    public abstract void setTakeOrder(boolean isTakeOrder);
}

class Human extends People {
    public Human(String name) {
        super(name);
    }
//
//    @Override
//    public void setMakeOrder(boolean isMakeOrder) {
//        this.isMakeOrder = isMakeOrder;
//    }
//
//    @Override
//    public void setTakeOrder(boolean isTakeOrder) {
//        this.isTakeOrder = isTakeOrder;
//    }

    @Override
    public void setMakeOrder() {
        this.isMakeOrder = isMakeOrder;
    }

    @Override
    public void setTakeOrder() {
        this.isTakeOrder = isTakeOrder;
    }
}


class Market implements MarketBehaviour, QueueBehaviour {

    private List<People> queue;
    public Market(){
        queue = new ArrayList<>();
    }

    @Override
    public void takeInQueue(People people) {
        queue.add(people);
        System.out.println(people.getName() + "Становится в очередь");
    }

    @Override
    public void takeOrders(People people) {
        people.
    }

    @Override
    public void giveOrders(People people) {

    }

    @Override
    public void releaseFromQueue(People people) {

    }

    @Override
    public void acceptToMarket(People people) {

    }

    @Override
    public void releaseFromMarket(List<People> queue) {

    }

    @Override
    public void update() {

    }
}


public class oop_dz_2 {
    public static void main(String[] args) {

    }
}
