package com.techelevator;

public class Money {

    public int balance;

    public Money() {
        balance = 0;
    }

    public void addMoney(int amountToDeposit) {
        balance = balance + (amountToDeposit * 100);
    }

    public int withdrawMoney(int amountToWithdraw) {
        balance = balance - (amountToWithdraw);
            return balance;
        }


    public int getBalanceInPennies() {
        return balance;
    }

    public String getBalanceAsString() {
        int currentBalanceAsInt = balance;
        double currentBalanceAsDouble = (currentBalanceAsInt / 100.00);
        String doubleAsString = "$" + String.format("%.2f", currentBalanceAsDouble);
        return doubleAsString;
    }

    public String returnChangeInCoins(int balance) {
        int coinTracker = balance;

        int quartersToReturn = 0;
        int dimesToReturn = 0;
        int nickelsToReturn = 0;

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        while (coinTracker > 0) {
            if (coinTracker >= quarter) {
                quartersToReturn++;
                coinTracker -= quarter;
            } else if (coinTracker >= dime) {
                dimesToReturn++;
                coinTracker -= dime;
            } else if (coinTracker >= nickel) {
                nickelsToReturn++;
                coinTracker -= nickel;
            }
        }
    this.balance = 0;
        System.out.println();
        String customerChangeMessage = "*** Change Due: " + quartersToReturn + " quarters, " + dimesToReturn +
                " dimes, " + nickelsToReturn + " nickels ***";
        return customerChangeMessage;

    }
}

