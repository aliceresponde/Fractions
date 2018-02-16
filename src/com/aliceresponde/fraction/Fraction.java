package com.aliceresponde.fraction;

import com.com.aliceresponde.fraction.utils.Calculate;
import com.google.common.base.Preconditions;

/**
 *  NOTE : Denominator cant be ZERO or NEGATIVE
 */
public final class Fraction {

    public static final int ZERO = 0;
    public static final String FRACTION_FORMAT = "%d/%d";

    private final int denominator;
    private final int numerator;

    private Fraction(final Builder builder) {
        this.denominator = builder.denominator;
        this.numerator = builder.numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public Fraction add(final Fraction fractionB) {
        return Calculate.add(this, fractionB);
    }

    public Fraction minus(final Fraction otherFraction){
        return   Calculate.minus(this, otherFraction);
    }

    public Fraction simplify() {
        return Calculate.simplify(this);
    }

    public Fraction multiply(Fraction fractionB) {
        return  Calculate.multiply(this, fractionB);
    }

    public Fraction divide(Fraction fractionB) {
        return  Calculate.divide(this, fractionB);
    }

    public static class Builder {
        private int numerator;
        private int denominator;

        public Builder withNumerator(final int numerator) {
            this.numerator = numerator;
            this.denominator = 1;
            return this;
        }

        public Builder withDenominator(final int denominator) {
            Preconditions.checkArgument(denominator >= 0, "Denominator must be different to zero");
            this.denominator = denominator;
            return this;
        }

        public Fraction build() {
            return new Fraction(this);
        }
    }

    @Override
    public boolean equals(final Object other) {
        Fraction fractionA = this.simplify();
        Fraction fractionB = ((Fraction) other).simplify();

        return fractionA.denominator == fractionB.denominator && fractionB.numerator == fractionA.numerator;
    }

    @Override
    public String toString() {
        return String.format(FRACTION_FORMAT, numerator, denominator);
    }
}
