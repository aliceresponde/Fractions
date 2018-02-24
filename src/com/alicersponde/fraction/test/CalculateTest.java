package com.alicersponde.fraction.test;


import com.aliceresponde.fraction.Fraction;
import com.com.aliceresponde.fraction.utils.Calculate;
import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {

    @Test
    public void elMCDDeUnNumeroYSuNegativoEsElNegativo(){
        Assert.assertEquals(-5, Calculate.mcd(5,-5));
    }

    @Test
    public void elMCDDeUnNumeroNegativoYSuPositivoEsSuPositivo(){
        Assert.assertEquals(5, Calculate.mcd(-5,5));
    }

    @Test
    public void elMCDDeDosNumerosIgualesNegativos(){
        Assert.assertEquals(-5, Calculate.mcd(-5,-5));
    }

    @Test
    public void invertirUnaFraccionCambiaElValorEntreNumeradorYDenominador(){
        Fraction expectedFraction = new Fraction.Builder().withNumerator(8).withDenominator(2).build();
        Fraction fractionA = new Fraction.Builder().withNumerator(2).withDenominator(8).build();
        Assert.assertEquals( expectedFraction.toString() , Calculate.invert(fractionA).toString());
    }


}
