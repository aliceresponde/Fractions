package com.com.aliceresponde.fraction.utils;

import com.aliceresponde.fraction.Fraction;

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

    public static Fraction makeNegative(final Fraction fraction) {
        return new Fraction.Builder().withNumerator(-fraction.getNumerator())
                .withDenominator(fraction.getDenominator()).build();
    }

    /**
     *   A + (-B)
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction minus(final Fraction fractionA, final Fraction fractionB) {
        return simplify(add(fractionA, makeNegative(fractionB)));
    }

    /**
     *  A * B
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction multiply(final Fraction fractionA, final Fraction fractionB) {
        int numerator = fractionA.getNumerator() * fractionB.getNumerator();
        int denominator = fractionA.getDenominator() * fractionB.getDenominator();

        Fraction result = new Fraction.Builder().withNumerator(numerator).withDenominator(denominator).build();
        return simplify(result);
    }

    /**
     * 1/(a/b)  --- > b/a
     * @param fraction
     * @return
     */
    public static Fraction invert(final Fraction fraction) {
        return new Fraction.Builder()
                .withNumerator(fraction.getDenominator())
                .withDenominator(fraction.getNumerator())
                .build();
    }

    /**
     *  A * 1/B
     * @param fractionA
     * @param fractionB
     * @return
     */
    public static Fraction divide(final Fraction fractionA, final Fraction fractionB) {
        Fraction result = multiply(fractionA, invert(fractionB));
        return simplify(result);
    }
}
