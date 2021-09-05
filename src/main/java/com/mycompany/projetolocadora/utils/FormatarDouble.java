package com.mycompany.projetolocadora.utils;

public class FormatarDouble {
    
    public double formatarDoubleDuasCasas(double numero) {
        numero = Math.round(numero * 100);
        return numero / 100;
    }

}
