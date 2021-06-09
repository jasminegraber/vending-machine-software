package com.techelevator;

public class Gum extends Item {

    public Gum(String name, String price) {
        super(name, price);
    }

    @Override
    public String getItemDispenseMessage() {
        return "\"Chew Chew, Yum!\"";
    }

    @Override
    public String toString() {
        return name + " " + price;

    }
}

