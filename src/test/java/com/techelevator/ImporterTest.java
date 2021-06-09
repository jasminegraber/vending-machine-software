package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImporterTest {

    private Importer importerTest;

    @Before
    public void new_object() {
        importerTest = new Importer();
    }

    @Test
    public void name_at_D2_test(){
        Assert.assertEquals("Little League Chew", importerTest.mapOfSlotAndItem().get("D2").getName());
    }

    @Test
    public void price_at_D2_test(){
        Assert.assertEquals("0.95", importerTest.mapOfSlotAndItem().get("D2").getPrice());
    }


}
