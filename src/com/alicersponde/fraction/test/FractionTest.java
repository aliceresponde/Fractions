package com.alicersponde.fraction.test;

import com.alicersponde.fraction.Fraction;
import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

    @Test
    public void simplofyFraction(){
        Fraction fraction = new Fraction (2520 , 4200);
        Fraction simplifiedFraction = fraction.simplity();
        Assert.assertEquals(new Fraction(3,5).toString() , simplifiedFraction.toString());
    }

    @Test
    public void createFractionWithDenominatorZero(){
        Fraction fraction = new Fraction (24 , 0);
        new AssertionError("Denominator must be different to zero");

    }
}
