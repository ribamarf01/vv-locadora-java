package com.mycompany.projetolocadora.controller;

import com.mycompany.projetolocadora.model.Aluguel;
import com.mycompany.projetolocadora.connection.DBConnector;
import com.mycompany.projetolocadora.dao.AluguelDAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.DataSource;

import java.time.temporal.ChronoUnit;

public class AluguelController {
    
    private AluguelDAO aluguelDAO;
    private final double precoBase = 1.1;
    private DataSource ds = DBConnector.getDataSource();

    public AluguelController() {
        this.aluguelDAO = new AluguelDAO(this.ds);
    }

    public boolean adicionarAluguel(Aluguel aluguel, int numeroDias) {
        LocalDate dataAluguel = LocalDate.now();
        aluguel.setDataAluguel(dataAluguel);
        
        if (numeroDias <= 0) return false;
        else aluguel.setDataDevolucao(dataAluguel.plusDays(numeroDias));
        
        aluguel.setValorAluguel((this.precoBase * numeroDias));
        aluguel.setEstaPago(false);
        aluguel.setValorMulta(0);
        return this.aluguelDAO.adicionarAluguel(aluguel);
    }

    public ArrayList<Aluguel> listarAlugueis() {
        return this.aluguelDAO.listarAlugueis();
    }

    public Aluguel buscarPorId(long id) {
        return this.aluguelDAO.buscarPorId(id);
    }

    public ArrayList<Aluguel> buscarAluguelPorPessoaOuFilme(int tipo, long id) {
        ArrayList<Aluguel> resultado;
        switch(tipo) {
            case 1:
                resultado = this.aluguelDAO.buscarPorPessoa(id);
                break;
            case 2:
                resultado = this.aluguelDAO.buscarPorFilme(id);
                break;
            default:
                resultado = null;
                break;
        }
        return resultado;
    }

    public boolean atualizarAluguel(Aluguel aluguel) {
        return this.aluguelDAO.atualizarAluguel(aluguel);
    }

    public void calcularMulta(Aluguel aluguel) {
        LocalDate dataAtual = LocalDate.now();
        if(dataAtual.isAfter(aluguel.getDataDevolucao())) {
            long dias = ChronoUnit.DAYS.between(aluguel.getDataDevolucao(), dataAtual);
            double multaPorDia = aluguel.getValorAluguel() * 0.1;
            aluguel.setValorMulta(dias * multaPorDia);
            atualizarAluguel(aluguel);
        }
    }

    public boolean quitarAluguel(Aluguel aluguel) {
        aluguel.setEstaPago(true);
        return atualizarAluguel(aluguel);
    }

}
