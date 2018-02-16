package com.com.aliceresponde.fraction.utils;

import com.aliceresponde.fraction.Fraction;

import java.util.Comparator;

public final class Calculate {

    private Calculate() {
        new AssertionError("No instantiable class");
    }

    /**
     * Maximun Common divisor.
     *
     * @param a
     * @param b
     * @return
     */
    public static int mcd(final int a, final int b) {
        return b == 0 ? a : mcd(b, a % b);
    }

    /**
     * Least Common multiple.
     *
     * @param a
     * @param b
     * @return
     */
    public static int mcm(final int a, final int b) {
        return (a * b) / mcd(a, b);
    }

    public static boolean isPositiveFraction(final int numerator, final int denominator) {
        return numerator * denominator >= 0;
    }

    private static int mcd(final Fraction fraction) {
        return mcd(fraction.getNumerator(), fraction.getDenominator());
    }

    /**
     * Return a the fraction simplified
     * @param fraction
     * @return
     */
    public static Fraction simplify(final Fraction fraction) {
        int mcd = mcd(fraction);
        int newNumerator = fraction.getNumerator() / mcd;
        int newDenominador = fraction.getDenominator() / mcd;

        return new Fraction.Builder().withNumerator(newNumerator).withDenominator(newDenominador).build();
    }

    /**
     * Addition between 2 fractions
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction add(final Fraction fractionA, final Fraction fractionB) {
        int newDenominator = mcm(fractionA.getDenominator(), fractionB.getDenominator());
        int a = (newDenominator / fractionA.getDenominator()) * fractionA.getNumerator();
        int b = (newDenominator / fractionB.getDenominator()) * fractionB.getNumerator();
        int newNumerator = a + b;

        Fraction result = new Fraction.Builder().withNumerator(newNumerator).withDenominator(newDenominator)
                .build();
        return simplify(result);
    }

    public static Fraction minus(final Fraction fractionA, final Fraction fractionB) {
        int newDenominator = mcm(fractionA.getDenominator(), fractionB.getDenominator());
        int a = (newDenominator / fractionA.getDenominator()) * fractionA.getNumerator();
        int b = (newDenominator / fractionB.getDenominator()) * fractionB.getNumerator();
        int newNumerator = a - b;

        Fraction result = new Fraction.Builder().withNumerator(newNumerator).withDenominator(newDenominator).build();

        return simplify(result);
    }

    public static Fraction multiply(final Fraction fractionA, final Fraction fractionB) {
        int numerator = fractionA.getNumerator() * fractionB.getNumerator();
        int denominator = fractionA.getDenominator() * fractionB.getDenominator();

        Fraction result = new Fraction.Builder().withNumerator(numerator).withDenominator(denominator).build();
        return simplify(result);
    }

    public static Fraction divide(final Fraction fractionA, final Fraction fractionB) {
        int numerator = fractionA.getNumerator() * fractionB.getDenominator();
        int denominator = fractionA.getDenominator() * fractionB.getNumerator();

        Fraction result = new Fraction.Builder().withNumerator(numerator).withDenominator(denominator).build();
        return simplify(result);
    }
}
