package com.techelevator;

public abstract class Item {
    String name;
    String price;

    public Item (String name, String price) {
        this.name = name;
        this.price = price;
    }

    //getters
    public abstract String getItemDispenseMessage();
    public abstract String toString();

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public int getPriceAsIntInPennies() {
        price = price.replace("$", "").replace(".", "");
        return Integer.parseInt(price);
    }

}
