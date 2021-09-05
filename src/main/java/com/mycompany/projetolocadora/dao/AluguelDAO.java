package com.mycompany.projetolocadora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import javax.sql.DataSource;

import java.util.ArrayList;

import com.mycompany.projetolocadora.model.Aluguel;

public class AluguelDAO {

    private DataSource ds;

    public AluguelDAO(DataSource ds) {
        this.ds = ds;
    }

    public boolean adicionarAluguel(Aluguel aluguel) {
        String sql = "INSERT INTO tb_aluguel(idPessoa, idFilme, dataAluguel, dataDevolucao, valorAluguel, valorMulta, estaPago) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aluguel.getIdPessoa());
            ps.setLong(2, aluguel.getIdFilme());
            ps.setDate(3, Date.valueOf(aluguel.getDataAluguel()));
            ps.setDate(4, Date.valueOf(aluguel.getDataDevolucao()));
            ps.setDouble(5, aluguel.getValorAluguel());
            ps.setDouble(6, 0);
            ps.setBoolean(7, false);
            System.out.println(aluguel.getDataAluguel() + ", " + Date.valueOf(aluguel.getDataAluguel()));
            System.out.println(aluguel.toString());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Aluguel> listarAlugueis() {
        String sql = "SELECT * FROM tb_aluguel";
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Aluguel a = new Aluguel();
                a.setId(rs.getLong("id"));;
                a.setIdPessoa(rs.getLong("idPessoa"));
                a.setIdFilme(rs.getLong("idFilme"));
                a.setDataAluguel(rs.getDate("dataAluguel").toLocalDate());
                a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
                a.setValorAluguel((double) rs.getDouble("valorAluguel"));
                a.setValorMulta((double)rs.getDouble("valorMulta"));
                a.setEstaPago(rs.getBoolean("estaPago"));
                alugueis.add(a);
            }

            ps.close();
            rs.close();

            return alugueis;
        } catch(SQLException e) {
            return null;
        }
    }

    public Aluguel buscarPorId(long id) {
        String sql = "SELECT * FROM tb_aluguel";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(!rs.first())
                return null;
            
            Aluguel a = new Aluguel();
            a.setId(rs.getLong("id"));;
            a.setIdPessoa(rs.getLong("idPessoa"));
            a.setIdFilme(rs.getLong("idFilme"));
            a.setDataAluguel(rs.getDate("dataAluguel").toLocalDate());
            a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
            a.setValorAluguel((double) rs.getDouble("valorAluguel"));
            a.setValorMulta((double)rs.getDouble("valorMulta"));
            a.setEstaPago(rs.getBoolean("estaPago"));
            
            ps.close();
            rs.close();

            return a;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Aluguel> buscarPorPessoa(long idPessoa) {
        String sql = "SELECT * FROM tb_aluguel WHERE idPessoa = ?";
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idPessoa);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Aluguel a = new Aluguel();
                a.setId(rs.getLong("id"));;
                a.setIdPessoa(rs.getLong("idPessoa"));
                a.setIdFilme(rs.getLong("idFilme"));
                a.setDataAluguel(rs.getDate("dataAluguel").toLocalDate());
                a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
                a.setValorAluguel((double) rs.getDouble("valorAluguel"));
                a.setValorMulta((double)rs.getDouble("valorMulta"));
                a.setEstaPago(rs.getBoolean("estaPago"));
                alugueis.add(a);
            }

            ps.close();
            rs.close();

            return alugueis;
        } catch(SQLException e) {
            return null;
        }
    }

    public ArrayList<Aluguel> buscarPorFilme(long idFilme) {
        String sql = "SELECT * FROM tb_aluguel WHERE idFilme = ?";
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idFilme);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Aluguel a = new Aluguel();
                a.setId(rs.getLong("id"));;
                a.setIdPessoa(rs.getLong("idPessoa"));
                a.setIdFilme(rs.getLong("idFilme"));
                a.setDataAluguel(rs.getDate("dataAluguel").toLocalDate());
                a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
                a.setValorAluguel((double) rs.getDouble("valorAluguel"));
                a.setValorMulta((double)rs.getDouble("valorMulta"));
                a.setEstaPago(rs.getBoolean("estaPago"));
                alugueis.add(a);
            }

            ps.close();
            rs.close();

            return alugueis;
        } catch(SQLException e) {
            return null;
        }
    }

    public boolean atualizarAluguel(Aluguel aluguel) {
        String sql = "UPDATE tb_aluguel SET idPessoa = ?, idFilme = ?, dataAluguel = ?, dataDevolucao = ?, valorAluguel = ?, valorMulta = ?, estaPago = ? WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aluguel.getIdPessoa());
            ps.setLong(2, aluguel.getIdFilme());
            ps.setDate(3, Date.valueOf(aluguel.getDataAluguel()));
            ps.setDate(4, Date.valueOf(aluguel.getDataDevolucao()));
            ps.setDouble(5, aluguel.getValorAluguel());
            ps.setDouble(6, aluguel.getValorMulta());
            ps.setBoolean(7, aluguel.isEstaPago());
            ps.setLong(8, aluguel.getId());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // Para teste, mas o estaPago em model.Aluguel funcionará como meio que um soft-delete
    public boolean excluirAluguel(Aluguel aluguel) {
        String sql = "UPDATE tb_aluguel SET estaPago = 1 WHERE id = ?";
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, aluguel.getId());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
