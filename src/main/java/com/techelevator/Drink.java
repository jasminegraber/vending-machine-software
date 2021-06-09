package com.techelevator;

public class Drink extends Item{

    public Drink(String name, String price) {
        super(name, price);
    }

    @Override
    public String getItemDispenseMessage() {
        return "\"Glug Glug, Yum!\"";
    }

    @Override
    public String toString() {
        return name + " " + price;

    }
}
