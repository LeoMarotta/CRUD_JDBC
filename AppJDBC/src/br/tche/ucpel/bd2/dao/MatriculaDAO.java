/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.dao;

/**
 *
 * @author leomarotta
 */

import br.tche.ucpel.bd2.bean.Matricula;
import br.tche.ucpel.bd2.bean.Disciplina;
import br.tche.ucpel.bd2.bean.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Connection conexao;
    private DisciplinaDAO disciplinaDAO;
    private AlunoDAO alunoDAO;

    public MatriculaDAO(Connection conexao) {
        this.conexao = conexao;
        this.disciplinaDAO = new DisciplinaDAO(conexao);
        this.alunoDAO = new AlunoDAO(conexao);
    }

    public void create(Matricula matricula) throws SQLException {
        if (this.valida(matricula)) {
            String sql = "INSERT INTO MATRICULA (COD, NOME, COD_D, COD_A) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1, matricula.getCod());
                pst.setString(2, matricula.getNome());
                pst.setInt(3, (matricula.getDisciplina()).getCod());
                pst.setInt(4, (matricula.getAluno()).getCod());
                pst.executeUpdate();

                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        matricula.setCod(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do aluno criado.");
                    }
                }
            }
        }
    }
    
    public Matricula retrieve(Matricula matricula) throws SQLException {
        Matricula matriculaRet = null;
        String sql = "SELECT COD, NOME, COD_D, COD_A FROM MATRICULA WHERE COD=?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, matricula.getCod());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    matriculaRet = new Matricula();
                    matriculaRet.setCod(rs.getInt("COD"));
                    matriculaRet.setNome(rs.getString("NOME"));
                    Disciplina disciplinaAssociada = disciplinaDAO.retrieve(new Disciplina(rs.getInt("COD_D")));
                    matriculaRet.setDisciplina(disciplinaAssociada);
                    Aluno alunoAssociado = alunoDAO.retrieve(new Aluno(rs.getInt("COD_A")));
                    matriculaRet.setAluno(alunoAssociado);
                }
            }
        }
        return matriculaRet;
    }    
    
    public void delete(Matricula matricula) throws SQLException {
        String sql = "DELETE FROM MATRICULA WHERE COD=?";
        try (PreparedStatement pst = this.conexao.prepareStatement(sql)) {
            pst.setInt(1, matricula.getCod());
            pst.executeUpdate();
        }
    }
    
    public List<Matricula> listaTodos() throws SQLException {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT COD, NOME, COD_D, COD_A FROM MATRICULA ORDER BY COD";

        try (Statement st = this.conexao.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getInt("COD"), rs.getString("NOME"));

                Disciplina disciplinaAssociada = disciplinaDAO.retrieve(new Disciplina(rs.getInt("COD_D")));
                matricula.setDisciplina(disciplinaAssociada);

                Aluno alunoAssociado = alunoDAO.retrieve(new Aluno(rs.getInt("COD_A")));
                matricula.setAluno(alunoAssociado);

                lista.add(matricula);
            }
        }
        return lista;
    }

    
    public boolean valida(Matricula matricula) {
        return matricula != null;
    }
}
