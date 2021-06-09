package com.techelevator;

public class Chip extends Item {

    public Chip(String name, String price) {
        super(name, price);
    }

    @Override
    public String getItemDispenseMessage() {
        return "\"Crunch Crunch, Yum!\"";
    }

    @Override
    public String toString() {
        return name + " " + price;

    }
}
