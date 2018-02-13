package com.alicersponde.fraction;

import com.com.aliceresponde.fraction.utils.Calculate;
import com.google.common.base.Preconditions;

/**
 *  NOTE : Denominator cant be ZERO
 */
public final class Fraction {

    public static final int ZERO = 0;
    public static final String FRACTION_FORMAT = "%d/%d";
    private int denominator;
    private int numerator;

    public Fraction(int numerator, int denominator) {
        Preconditions.checkArgument(denominator != 0, "Denominator must be different to zero");

        this.denominator = denominator;
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public  Fraction simplity() {
        return Calculate.simplify(this);
    }

    public Fraction add(Fraction fractionB){
        return Calculate.add(this, fractionB );
    }


    @Override
    public String toString() {
        return String.format(FRACTION_FORMAT, numerator, denominator);

    }
}
