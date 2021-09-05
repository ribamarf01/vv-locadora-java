package com.mycompany.projetolocadora.dao;

import com.mycompany.projetolocadora.model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class FilmeDAO {

    private DataSource ds;

    public FilmeDAO(DataSource ds) {
        this.ds = ds;
    }

    public long numFilmes() {
        String sql = "SELECT COUNT(*) FROM tb_filmes";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            rs.first();
            long count = rs.getLong(1);
            ps.close();
            rs.close();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean filmeJaCadastrado(Filme filme) {
        String sql = "SELECT * FROM tb_filme WHERE titulo = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filme.getTitulo());
            ResultSet rs = ps.executeQuery();

            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adicionarFilme(Filme filme) {
        // if(filmeJaCadastrado(filme)) return false;
        // else {
            String sql = "INSERT INTO tb_filme(titulo, descricao, genero, ano, duracao, diretor, estudio) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, filme.getTitulo());
                ps.setString(2, filme.getDescricao());
                ps.setString(3, filme.getGenero());
                ps.setString(4, filme.getAno());
                ps.setString(5, filme.getDuracao());
                ps.setString(6, filme.getDiretor());
                ps.setString(7, filme.getEstudio());

                ps.execute();
                ps.close();
                return true;
            } catch(SQLException e) {
                return false;
            }
        // }
    }

    public ArrayList<Filme> listarFilmes() {
        String sql = "SELECT * FROM tb_filme";
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getLong("id"));
                f.setTitulo(rs.getString("titulo"));
                f.setDescricao(rs.getString("descricao"));
                f.setGenero(rs.getString("genero"));
                f.setAno(rs.getString("ano"));
                f.setDuracao(rs.getString("duracao"));
                f.setDiretor(rs.getString("diretor"));
                f.setEstudio(rs.getString("estudio"));
                filmes.add(f);
            }

            ps.close();
            rs.close();
            return filmes;
        } catch (SQLException e) {
            return null;
        }
    }

    public Filme buscarPeloId(long id) {
        String sql = "SELECT * FROM tb_filme WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Filme f = new Filme();
            f.setId(rs.getLong("id"));
            f.setTitulo(rs.getString("titulo"));
            f.setDescricao(rs.getString("descricao"));
            f.setGenero(rs.getString("genero"));
            f.setAno(rs.getString("ano"));
            f.setDuracao(rs.getString("duracao"));
            f.setDiretor(rs.getString("diretor"));
            f.setEstudio(rs.getString("estudio"));
            
            ps.close();
            rs.close();
            return f;
        } catch (SQLException e) {
            return null;
        }
    }

    public Filme buscarPeloTitulo(String titulo) {
        String sql = "SELECT * FROM tb_filme WHERE titulo = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Filme f = new Filme();
            f.setId(rs.getLong("id"));
            f.setTitulo(rs.getString("titulo"));
            f.setDescricao(rs.getString("descricao"));
            f.setGenero(rs.getString("genero"));
            f.setAno(rs.getString("ano"));
            f.setDuracao(rs.getString("duracao"));
            f.setDiretor(rs.getString("diretor"));
            f.setEstudio(rs.getString("estudio"));
            
            ps.close();
            rs.close();
            return f;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Filme> buscarPeloGenero(String genero) {
        String sql = "SELECT * FROM tb_filme WHERE genero = ?";
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getLong("id"));
                f.setTitulo(rs.getString("titulo"));
                f.setDescricao(rs.getString("descricao"));
                f.setGenero(rs.getString("genero"));
                f.setAno(rs.getString("ano"));
                f.setDuracao(rs.getString("duracao"));
                f.setDiretor(rs.getString("diretor"));
                f.setEstudio(rs.getString("estudio"));
                filmes.add(f);
            }

            ps.close();
            rs.close();
            return filmes;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Filme> buscarPorDiretor(String diretor) {
        String sql = "SELECT * FROM tb_filme WHERE diretor = ?";
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, diretor);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getLong("id"));
                f.setTitulo(rs.getString("titulo"));
                f.setDescricao(rs.getString("descricao"));
                f.setGenero(rs.getString("genero"));
                f.setAno(rs.getString("ano"));
                f.setDuracao(rs.getString("duracao"));
                f.setDiretor(rs.getString("diretor"));
                f.setEstudio(rs.getString("estudio"));
                filmes.add(f);
            }

            ps.close();
            rs.close();
            return filmes;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean atualizarFilme(long id, Filme filme) {
        String sql = "UPDATE tb_filme SET titulo = ?, descricao = ?, genero = ?, ano = ?, duracao = ?, diretor = ?, estudio = ? WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getDescricao());
            ps.setString(3, filme.getGenero());
            ps.setString(4, filme.getAno());
            ps.setString(5, filme.getDuracao());
            ps.setString(6, filme.getDiretor());
            ps.setString(7, filme.getEstudio());
            ps.setLong(8, id);

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean excluirFilme(long id) {
        String sql = "DELETE FROM tb_filme WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
