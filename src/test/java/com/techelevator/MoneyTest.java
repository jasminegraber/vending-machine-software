package com.techelevator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class MoneyTest {

    private Money moneyTest;

    @Before
    public void setup() {
        moneyTest = new Money();
    }
    
    @Test

    public void correct_amount_deposited() {
        moneyTest.addMoney(1);
        Assert.assertEquals(100, moneyTest.getBalanceInPennies());
    }


    @Test
    public void correct_amount_deposited_5() {
        moneyTest.addMoney(5);
        Assert.assertEquals(500, moneyTest.getBalanceInPennies());
    }
    @Test
    public void correct_amount_withdraw() {
        moneyTest.addMoney(1);
        moneyTest.withdrawMoney(25);
        Assert.assertEquals(75, moneyTest.getBalanceInPennies());
    }

    @Test
    public void balance_is_set_to_zero_by_default() {
        Assert.assertEquals(0, moneyTest.getBalanceInPennies());
    }

    @Test
    public void return_one_dollar_as_coins_zero_balance() {
        moneyTest.addMoney(1);
        Assert.assertEquals("*** Change Due: 4 quarters, 0 dimes, 0 nickels ***", moneyTest.returnChangeInCoins(moneyTest.getBalanceInPennies()));
        Assert.assertEquals(0, moneyTest.getBalanceInPennies());
    }
    @Test
    public void return_one_dollar_as_coins() {
        moneyTest.addMoney(1);
        Assert.assertEquals("*** Change Due: 4 quarters, 0 dimes, 0 nickels ***", moneyTest.returnChangeInCoins(moneyTest.getBalanceInPennies()));
    }



    @Test
    public void return_one_dollar_twenty_as_coins() {
        moneyTest.addMoney(2);
        moneyTest.withdrawMoney(80);
        Assert.assertEquals("*** Change Due: 4 quarters, 2 dimes, 0 nickels ***", moneyTest.returnChangeInCoins(moneyTest.getBalanceInPennies()));
    }

    @Test
    public void return_one_thirty_five_as_coins() {
        moneyTest.addMoney(2);
        moneyTest.withdrawMoney(65);
        Assert.assertEquals("*** Change Due: 5 quarters, 1 dimes, 0 nickels ***", moneyTest.returnChangeInCoins(moneyTest.getBalanceInPennies()));
    }

}
