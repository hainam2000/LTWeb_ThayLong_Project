package model;

import java.io.Serializable;

public class Shipping implements Serializable {
    private int id;
    private String name;
    private int price;

    public Shipping(){

    }
    public Shipping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
