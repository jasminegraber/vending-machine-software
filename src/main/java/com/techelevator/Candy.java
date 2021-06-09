package com.techelevator;

public class Candy extends Item {

    public Candy(String name, String price) {
        super(name, price);
    }

    @Override
    public String getItemDispenseMessage() {
        return "\"Munch Munch, Yum!\"";
    }

    @Override
    public String toString() {
        return name + " " + price;

    }


}
