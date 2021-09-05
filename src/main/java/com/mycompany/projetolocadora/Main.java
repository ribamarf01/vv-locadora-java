package com.mycompany.projetolocadora;

import com.mycompany.projetolocadora.controller.AluguelController;
import com.mycompany.projetolocadora.model.Aluguel;
import com.mycompany.projetolocadora.views.MainView;

public class Main {
    
    public static void main(String[] args) {
        try {
            new MainView().setVisible(true);
        } catch(Exception e) {
            System.out.println("Erro: " + e);
        }

        // AluguelController ac = new AluguelController();
        // for (Aluguel a : ac.listarAlugueis()) {
        //     System.out.println(a.toString());
        // }
    }
    
}
