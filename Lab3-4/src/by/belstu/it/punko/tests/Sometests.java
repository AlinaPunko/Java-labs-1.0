package by.belstu.it.punko.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Sometests {
    @Before
    public  void setUpToHexStringData() {
        System.out.println("Делаем до");
    }

    @After
    public  void tearDownToHexStringData() {
        System.out.println("Делаем после");
    }

    @Test
    public void testToHexString() {
        System.out.println("Что-то делаем");
    }
}
