package com.mycompany.projetolocadora.controller;

import com.mycompany.projetolocadora.model.Pessoa;
import com.mycompany.projetolocadora.connection.DBConnector;
import com.mycompany.projetolocadora.dao.PessoaDAO;

import java.util.ArrayList;

import javax.sql.DataSource;

public class PessoaController {
    
    private PessoaDAO pessoaDAO;
    private DataSource ds = DBConnector.getDataSource();

    public PessoaController() {
        this.pessoaDAO = new PessoaDAO(this.ds);
    }
    
    public long numeroClientesCadastrados() {
        return this.pessoaDAO.numPessoas();
    }

    public boolean adicionarCliente(Pessoa pessoa) {
        return this.pessoaDAO.adicionarPessoa(pessoa);
    }

    public ArrayList<Pessoa> listarClientes() {
        return this.pessoaDAO.listarPessoas();
    }

    public Pessoa buscarCliente(long id) {
        return this.pessoaDAO.buscarPeloId(id);
    }

    public Pessoa buscarCliente(String cpf) {
        return this.pessoaDAO.buscarPeloCpf(cpf);
    }

    public boolean atualizarCliente(Pessoa pessoa) {
        return this.pessoaDAO.atualizarPessoa(pessoa);
    }

    public boolean excluirCliente(Pessoa pessoa) {
        return this.pessoaDAO.excluirPessoa(pessoa);
    }

}