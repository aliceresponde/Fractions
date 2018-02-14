package com.aliceresponde.fraction;

import com.com.aliceresponde.fraction.utils.Calculate;
import com.google.common.base.Preconditions;

/**
 *  NOTE : Denominator cant be ZERO
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

    public Fraction simplity() {
        return Calculate.simplify(this);
    }

    public Fraction add(Fraction fractionB) {
        return Calculate.add(this, fractionB);
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
            this.denominator = denominator;
            return this;
        }

        public Fraction build() {
            Preconditions.checkArgument(denominator != 0, "Denominator must be different to zero");
            return new Fraction(this);
        }
    }

    @Override
    public String toString() {
        return String.format(FRACTION_FORMAT, numerator, denominator);
    }
}
