package com.com.aliceresponde.fraction.utils;

import com.alicersponde.fraction.Fraction;

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
    public static int mcd(int a, int b) {
        return b == 0 ? a : mcd(b, a % b);
    }

    /**
     * Least Common multiple.
     *
     * @param a
     * @param b
     * @return
     */
    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
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
        return new Fraction(newNumerator, newDenominador);
    }

    public static Fraction add(final Fraction fractionA, final Fraction fractionB){
        int newDenominator = mcm(fractionA.getDenominator(),fractionB.getDenominator());
        int a =  (fractionB.getDenominator()/newDenominator) * fractionA.getNumerator() ;
        int b =  (fractionA.getDenominator()/newDenominator) * fractionB.getNumerator();
        int newNumerator = a + b;
        return  new Fraction(newNumerator, newDenominator);

    }

}
