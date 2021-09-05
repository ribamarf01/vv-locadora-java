package com.mycompany.projetolocadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mycompany.projetolocadora.model.Pessoa;
import com.mycompany.projetolocadora.utils.FormatarString;

public class PessoaDAO {

    private DataSource ds;

    public PessoaDAO(DataSource ds) {
        this.ds = ds;
    }

    public long numPessoas() {
        String sql = "SELECT COUNT(*) from tb_pessoa";
        try {
            Connection con = ds.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            int total = rs.getInt(1);
            stmt.close();
            rs.close();
            return total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    public boolean adicionarPessoa(Pessoa pessoa) {
        // if (pessoaJaCadastrada(pessoa))
        //     return false;
        // else {
            String sql = "INSERT INTO tb_pessoa(nome_completo, cpf, telefone, sexo, data_nascimento, endereco, email) VALUES (?, ?, ?, ?, ?, ?, ?);";
            try {
                Connection con = ds.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, pessoa.getNomeCompleto());
                stmt.setString(2, pessoa.getCpf());
                stmt.setString(3, pessoa.getTelefone());
                stmt.setString(4, pessoa.getSexo());
                stmt.setString(5, pessoa.getDataNascimento());
                stmt.setString(6, pessoa.getEndereco());
                stmt.setString(7, pessoa.getEmail());
                stmt.execute();
                stmt.close();

                return true;
            } catch (SQLException e) {
                return false;
            }
        // }
    }

    public ArrayList<Pessoa> listarPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM tb_pessoa";

        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setSexo(rs.getString("sexo"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setEndereco(rs.getString("endereco"));
                p.setEmail(rs.getString("email"));

                pessoas.add(p);
            }
            ps.close();
            rs.close();

            return pessoas;
        } catch (SQLException e) {
            return null;
        }
    }

    public Pessoa buscarPeloId(long id) {
        String sql = "SELECT * from tb_pessoa WHERE id = ?";

        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Pessoa p = new Pessoa();

            if(!rs.first())
                return null;

            p.setId(rs.getLong("id"));
            p.setNomeCompleto(rs.getString("nome_completo"));
            p.setCpf(rs.getString("cpf"));
            p.setTelefone(rs.getString("telefone"));
            p.setSexo(rs.getString("sexo"));
            p.setDataNascimento(rs.getString("data_nascimento"));
            p.setEndereco(rs.getString("endereco"));
            p.setEmail(rs.getString("email"));

            ps.close();
            rs.close();

            return p;
        } catch (SQLException e) {
            return null;
        }
    }

    public Pessoa buscarPeloCpf(String cpf) {
        String sql = "SELECT * from tb_pessoa WHERE cpf = ?";
        cpf = new FormatarString().formatarString(cpf, "###.###.###-##");
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            Pessoa p = new Pessoa();

            if(rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setSexo(rs.getString("sexo"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setEndereco(rs.getString("endereco"));
                p.setEmail(rs.getString("email"));
            } else return null;

            ps.close();
            rs.close();

            return p;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean atualizarPessoa(Pessoa pessoa) {
        String sql = "UPDATE tb_pessoa SET nome_completo = ?, cpf = ?, telefone = ?, sexo = ?, data_nascimento = ?, endereco = ?, email = ? WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomeCompleto());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getSexo());
            stmt.setString(5, pessoa.getDataNascimento());
            stmt.setString(6, pessoa.getEndereco());
            stmt.setString(7, pessoa.getEmail());
            stmt.setLong(8, pessoa.getId());
            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean excluirPessoa(Pessoa pessoa) {
        String sql = "DELETE FROM tb_pessoa WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, pessoa.getId());
            ps.execute();
            ps.close();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    private boolean pessoaJaCadastrada(Pessoa pessoa) {
        String sql = "SELECT * from tb_pessoa WHERE cpf = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getCpf());
            ResultSet rs = stmt.executeQuery();
            return !rs.first();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
