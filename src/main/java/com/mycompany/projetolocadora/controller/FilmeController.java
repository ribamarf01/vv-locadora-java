package com.mycompany.projetolocadora.controller;

import com.mycompany.projetolocadora.connection.DBConnector;
import com.mycompany.projetolocadora.dao.FilmeDAO;
import com.mycompany.projetolocadora.model.Filme;

import java.util.ArrayList;

import javax.sql.DataSource;

public class FilmeController {
    
    private FilmeDAO filmeDAO;
    private DataSource ds = DBConnector.getDataSource();

    public FilmeController() {
        this.filmeDAO = new FilmeDAO(this.ds);
    }

    public long numeroFilmesCadastrados() {
        return this.filmeDAO.numFilmes();
    }

    public boolean adicionarFilme(Filme filme) {
        return this.filmeDAO.adicionarFilme(filme);
    }

    public ArrayList<Filme> listarFilmes() {
        return this.filmeDAO.listarFilmes();
    }

    public Filme buscarFilmePorId(long id) {
        return this.filmeDAO.buscarPeloId(id);
    }

    public Filme buscarFilmePorTitulo(String titulo) {
        return this.filmeDAO.buscarPeloTitulo(titulo);
    }

    public ArrayList<Filme> buscarFilmePorGeneroOuDiretor(int tipo, String nome) {
        ArrayList<Filme> resultado = new ArrayList<>();
        switch(tipo) {
            case 1: 
                resultado = this.filmeDAO.buscarPeloGenero(nome);
                break;
            case 2:
                resultado = this.filmeDAO.buscarPorDiretor(nome);
                break;
            default:
                resultado = null;
                break;
        }
        return resultado;
    }

    public boolean atualizarFilme(Filme filme) {
        return this.filmeDAO.atualizarFilme(filme.getId(), filme);
    }

    public boolean excluirFilme(Filme filme) {
        return this.filmeDAO.excluirFilme(filme.getId());
    }

}
