/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.dao;

import br.tche.ucpel.bd2.bean.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    private Connection conexao;

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
            String sql = "INSERT INTO ALUNO (COD, NOME, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1, aluno.getCod());
                pst.setString(2, aluno.getNome());
                pst.setString(3, aluno.getEndereco());
                pst.setLong(4, aluno.getTelefone());
                pst.executeUpdate();

                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        aluno.setCod(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do aluno criado.");
                    }
                }
            }
        }
    }

    public Aluno retrieve(Aluno aluno) throws SQLException {
        Aluno alunoRet = null;
        String sql = "SELECT COD, NOME, ENDERECO, TELEFONE FROM ALUNO WHERE COD=?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, aluno.getCod());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    alunoRet = new Aluno();
                    alunoRet.setCod(rs.getInt("COD"));
                    alunoRet.setNome(rs.getString("NOME"));
                    alunoRet.setEndereco(rs.getString("ENDERECO"));
                    alunoRet.setTelefone(rs.getLong("TELEFONE"));
                }
            }
        }
        return alunoRet;
    }

    public void update(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
            String sql = "UPDATE ALUNO SET NOME=?, ENDERECO=?, TELEFONE=? WHERE COD=?";
            try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
                pst.setString(1, aluno.getNome());
                pst.setString(2, aluno.getEndereco());
                pst.setLong(3, aluno.getTelefone());
                pst.setInt(4, aluno.getCod());
                pst.executeUpdate();
            }
        }
    }

    public void delete(Aluno aluno) throws SQLException {
        String sql = "DELETE FROM ALUNO WHERE COD=?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, aluno.getCod());
            pst.executeUpdate();
        }
    }

    public List<Aluno> listaTodos() throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT COD, NOME, ENDERECO, TELEFONE FROM ALUNO ORDER BY COD";
        try (Statement st = this.conexao.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("COD"), 
                        rs.getString("NOME"), 
                        rs.getString("ENDERECO"),
                        rs.getLong("TELEFONE"));
                lista.add(aluno);
            }
        }
        return lista;
    }

    public boolean valida(Aluno aluno) {
        return aluno != null;
    }
}
