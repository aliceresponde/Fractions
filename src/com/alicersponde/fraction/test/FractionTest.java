package com.alicersponde.fraction.test;

import org.junit.Assert;
import org.junit.Test;

import com.aliceresponde.fraction.Fraction;

public class FractionTest {

    @Test
    public void simplifyFraction(){
        Fraction fraction = new Fraction.Builder()
                                        .withNumerator (2520)
                                        .withDenominator(4200)
                                        .build();

        Fraction simplifiedFraction = fraction.simplity();
        Assert.assertEquals("3/5", simplifiedFraction.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFractionWithDenominatorZero(){
        Fraction fraction = new Fraction.Builder()
                                        .withNumerator (2520)
                                        .withDenominator(0)
                                        .build();

        new AssertionError("Denominator must be different to zero");
    }

    @Test
    public void addTwoWholeFractions(){
        Fraction fractionA = new Fraction.Builder()
                                        .withNumerator (2520)
                                        .build();

        Fraction fractionB = new Fraction.Builder()
                                        .withNumerator (1)
                                        .build();

        Assert.assertEquals("2521/1", fractionA.add(fractionB).toString());
    }

    @Test
    public void addTwoFractions(){
        Fraction fractionA = new Fraction.Builder()
                                        .withNumerator (1)
                                        .withDenominator(2)
                                        .build();

        Fraction fractionB = new Fraction.Builder()
                                        .withNumerator (8)
                                        .withDenominator(3)
                                        .build();

        Assert.assertEquals("19/6", fractionA.add(fractionB).toString());
    }
}
