package test.stuff.bla.fizzBuzz;

import main.stuff.bla.fizzBuzz.FizzBuzz;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FizzBuzzTest {

    private int countTo = 21;
    FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
         this.fizzBuzz = new FizzBuzz(countTo);
    }

    @Test
    public void testResInstance(){
        Assert.assertEquals(0, this.fizzBuzz.getRes().size());
    }

    @Test
    public void testSizeOfRes(){
        this.fizzBuzz.playFizzBuzz();
        Assert.assertEquals(countTo,this.fizzBuzz.getRes().size());
    }

    @Test
    public void testResAtThree(){
        this.fizzBuzz.playFizzBuzz();
        Assert.assertEquals("Fizz".toUpperCase(), this.fizzBuzz.getRes().get(2).toUpperCase());
    }

    @Test
    public void testResAtFive(){
        this.fizzBuzz.playFizzBuzz();
        Assert.assertEquals("Buzz".toUpperCase(), this.fizzBuzz.getRes().get(4).toUpperCase());
    }

    @Test
    public void testResAtFifteen(){
        this.fizzBuzz.playFizzBuzz();
        Assert.assertEquals("FizzBuzz".toUpperCase(), this.fizzBuzz.getRes().get(14).toUpperCase());
    }
}