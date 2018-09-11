package test.stuff.bla.fizzBuzz;

import main.stuff.bla.fizzBuzz.FizzBuzzV2;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzV2Test {

    FizzBuzzV2 fizzBuzzV2;
    String resValueOfFizzBuzz;
    String THREES = "FIZZ";
    String FIVES = "BUZZ";
    String SEVENS = "WHIZZ";

    @BeforeEach
    void setUp() {
        this.fizzBuzzV2 = new FizzBuzzV2();
    }

    @Test
    void resTestAt3() {
        this.fizzBuzzV2.fizzBuzz(3);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals(THREES.toUpperCase(), this.resValueOfFizzBuzz);
    }

    @Test
    void resTestAt5() {
        this.fizzBuzzV2.fizzBuzz(5);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals(FIVES.toUpperCase(), this.resValueOfFizzBuzz);
    }

    @Test
    void resTestAt7() {
        this.fizzBuzzV2.fizzBuzz(7);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals(SEVENS.toUpperCase(), this.resValueOfFizzBuzz);
    }

    @Test
    void resTestAt8() {
        this.fizzBuzzV2.fizzBuzz(8);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals("8".toUpperCase(), this.resValueOfFizzBuzz);
    }

    @Test
    void resTestAt15() {
        this.fizzBuzzV2.fizzBuzz(15);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals((THREES + FIVES).toUpperCase(), this.resValueOfFizzBuzz);
    }

    @Test
    void resTestAt21() {
        this.fizzBuzzV2.fizzBuzz(21);
        this.resValueOfFizzBuzz = this.fizzBuzzV2.getRes().get(0).toUpperCase();
        Assert.assertEquals((THREES + SEVENS).toUpperCase(), this.resValueOfFizzBuzz);
    }
}