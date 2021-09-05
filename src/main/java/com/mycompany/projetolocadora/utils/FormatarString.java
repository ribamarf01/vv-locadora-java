package com.mycompany.projetolocadora.utils;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class FormatarString {
    
    public String formatarString(String value, String padrao) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(padrao);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch(ParseException ex) {
            return value;
        }
    }
    
}
