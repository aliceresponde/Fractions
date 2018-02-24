package com.alicersponde.fraction.test;

import com.com.aliceresponde.fraction.utils.Calculate;
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

        Fraction simplifiedFraction = fraction.simplify();
        Assert.assertEquals("3/5", simplifiedFraction.toString());
    }

    @Test(expected = IllegalArgumentException.class )
    public void createFractionWithDenominatorZero(){
        Fraction fraction = new Fraction.Builder()
                                        .withNumerator (2520)
                                        .withDenominator(0)
                                        .build();



    }

    @Test(expected = IllegalArgumentException.class)
    public void createFractionWithDenominatorNegative(){
        Fraction fraction = new Fraction.Builder()
                .withNumerator (2520)
                .withDenominator(-2)
                .build();
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
                                        .withNumerator (4)
                                        .withDenominator(5)
                                        .build();

        Fraction fractionB = new Fraction.Builder()
                                        .withNumerator (2)
                                        .withDenominator(10)
                                        .build();

        Assert.assertEquals("1/1", fractionA.add(fractionB).toString());
    }

    @Test
    public void twoEquivalentFractions(){
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (2)
                .withDenominator(4)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (1)
                .withDenominator(1)
                .build();

    }

    @Test
    public void aNegativeFractionWithNumeratorNegative(){
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (-2)
                .withDenominator(4)
                .build();

        Assert.assertEquals(false, Calculate.isPositiveFraction(fractionA.getNumerator(), fractionA.getDenominator()));
    }


    @Test
    public void multiplyFractions() {
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (-2)
                .withDenominator(4)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (-2)
                .withDenominator(4)
                .build();

        Assert.assertEquals("1/4", fractionA.multiply(fractionB).toString());
    }


    @Test
    public void divideFractions() {
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (3)
                .withDenominator(1)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (6)
                .withDenominator(1)
                .build();

        Assert.assertEquals("1/2", fractionA.divide(fractionB).toString());
    }



    @Test
    public void substractionsOf(){
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (1)
                .withDenominator(2)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (1)
                .withDenominator(2)
                .build();


        Assert.assertEquals("0/1", fractionA.minus(fractionB).toString());
    }

    @Test
    public void twoEquivalentFractionsAreEquals(){
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (1)
                .withDenominator(2)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (2)
                .withDenominator(4)
                .build();

        Assert.assertEquals(true, fractionA.equals(fractionB));
    }

    @Test
    public void zeroIsZero(){
        Fraction fractionA = new Fraction.Builder()
                .withNumerator (0)
                .withDenominator(2)
                .build();

        Fraction fractionB = new Fraction.Builder()
                .withNumerator (0)
                .withDenominator(122)
                .build();

        Assert.assertEquals(true, fractionA.equals(fractionB));
    }

}
