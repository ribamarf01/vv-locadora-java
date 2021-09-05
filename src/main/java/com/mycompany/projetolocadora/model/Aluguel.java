package com.mycompany.projetolocadora.model;

import java.time.LocalDate;

import com.mycompany.projetolocadora.utils.FormatarDouble;

public class Aluguel {

    private long id;
    private long idPessoa;
    private long idFilme;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private double valorAluguel;
    private double valorMulta;
    private boolean estaPago;

    public Aluguel() {
        this.estaPago = false;
        this.dataAluguel = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Aluguel: [dataAluguel=" + dataAluguel + ", dataDevolucao=" + dataDevolucao + ", estaPago=" + estaPago
                + ", id=" + id + ", idFilme=" + idFilme + ", idPessoa=" + idPessoa + ", valorAluguel=" + valorAluguel
                + ", valorMulta=" + valorMulta + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(long idFilme) {
        this.idFilme = idFilme;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = new FormatarDouble().formatarDoubleDuasCasas(valorAluguel);
    }

    public double getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = new FormatarDouble().formatarDoubleDuasCasas(valorMulta);
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

}
