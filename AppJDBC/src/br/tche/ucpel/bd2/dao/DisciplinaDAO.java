/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.dao;

import br.tche.ucpel.bd2.bean.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    
    private Connection conexao;

    public DisciplinaDAO(Connection conexao) {
        this.conexao = conexao;
    }

 public void create(Disciplina disciplina) throws SQLException {
    if (this.valida(disciplina)) {
        String sql = "INSERT INTO DISCIPLINA (COD, NOME, PROFESSOR) VALUES (?, ?, ?)";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, disciplina.getCod());
            pst.setString(2, disciplina.getNome());
            pst.setString(3, disciplina.getProfessor());
            pst.executeUpdate();

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    disciplina.setCod(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID da disciplina criada.");
                }
            }
        }
    }
}


public List<Disciplina> listaTodos() throws SQLException {
    List<Disciplina> disciplinas = new ArrayList<>();
    String sql = "SELECT COD, NOME, PROFESSOR FROM DISCIPLINA ORDER BY COD";
    try (Statement stmt = this.conexao.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setCod(rs.getInt("COD"));
            disciplina.setNome(rs.getString("NOME"));
            disciplina.setProfessor(rs.getString("PROFESSOR"));
            disciplinas.add(disciplina);
        }
    }
    return disciplinas;
}


    public Disciplina retrieve(Disciplina disciplina) throws SQLException {
        Disciplina disciplinaRet = null;
        String sql = "SELECT COD, NOME, PROFESSOR FROM DISCIPLINA WHERE COD = ?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, disciplina.getCod());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    disciplinaRet = new Disciplina();
                    disciplinaRet.setCod(rs.getInt("COD"));
                    disciplinaRet.setNome(rs.getString("NOME"));
                    disciplinaRet.setProfessor(rs.getString("PROFESSOR"));
                }
            }
        }
        return disciplinaRet;
    }



    public void update(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE DISCIPLINA SET NOME = ?, PROFESSOR = ? WHERE COD = ?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setString(1, disciplina.getNome());
            pst.setString(2, disciplina.getProfessor());
            pst.setInt(3, disciplina.getCod());
            pst.executeUpdate();
        }
    }

    public void delete(Disciplina disciplina) throws SQLException {
        String sql = "DELETE FROM DISCIPLINA WHERE COD = ?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, disciplina.getCod());
            pst.executeUpdate();
        }
    }    
    
    public boolean valida(Disciplina disciplina) {
        return disciplina != null;
    }
    
    public Disciplina findDisciplinaInDb(int cod) {
        Disciplina disciplina = null;
        String sql = "SELECT * FROM DISCIPLINA WHERE COD=?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, cod);  // Configurando o parâmetro na consulta SQL
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                disciplina = new Disciplina(
                    rs.getInt("COD"),
                    rs.getString("NOME"),
                    rs.getString("PROFESSOR")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplina;
    }

}
