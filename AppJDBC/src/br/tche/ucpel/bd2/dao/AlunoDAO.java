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

/**
 *
 * @author leomarotta
 */
public class AlunoDAO {
    
    private Connection conexao;

    /**
     * Construtor único, para garantir a existência de uma conexão com um SGBD
     *
     * @param conexao Connection já aberta com um SGBD
     */
    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Se o departamento for válido, este método irá fazer o INSERT no SGBD. O
     * Código será inserido pela Sequência e será colocado novamente no objeto
     * Departamento.
     *
     * @param dept Departamento a ser inserido
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void create(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
//            String sql = "INSERT INTO ALUNO (COD,NOME,ENDERECO,TELEFONE) VALUES (NEXTVAL('SEQALUNO'),?,?,?)";            // Insert Postgresql
            String sql = "INSERT INTO ALUNO (COD,NOME,ENDERECO,TELEFONE) VALUES (NEXT VALUE FOR SEQALUNO,?,?,?)";          // Insert Java DB 
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getEndereco());
            pst.setInt(3, aluno.getTelefone());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
//            ResultSet rs = st.executeQuery("SELECT CURRVAL('SEQDEPARTAMENTO')");     // Select sequence Postgresql
            ResultSet rs = st.executeQuery("SELECT MAX(COD) FROM DEPARTAMENTO");       // Select sequence Java DB
            if (rs.next()) {
                aluno.setCod(rs.getInt(1));
            }
            rs.close();
            st.close();
            pst.close();
        }
    }

    /**
     * Retorna o departamento do SGBD de acordo com o código do departamento
     * recebido.
     *
     * @param dept Departamento a ser carregado do SGBD
     * @return Departamento do SGBD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public Aluno retrieve(Aluno aluno) throws SQLException {
        Aluno alunoRet = null;
        String sql = "SELECT COD,NOME,ENDERECO, TELEFONE FROM DEPARTAMENTO WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, aluno.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            alunoRet = new Aluno();
            alunoRet.setCod(rs.getInt("COD"));
            alunoRet.setNome(rs.getString("NOME"));
            alunoRet.setEndereco(rs.getString("ENDERECO"));
            alunoRet.setTelefone(rs.getInt("TELEFONE"));
        }
        rs.close();
        pst.close();
        return alunoRet;
    }

    /**
     * Atualiza o departamento no SGBD.
     *
     * @param dept Departamento a ser atualizado do SGBD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void update(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
            String sql = "UPDATE DEPARTAMENTO SET NOME=? , ENDERECO=?, TELEFONE=? WHERE COD=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getEndereco());
            pst.setInt(3, aluno.getTelefone());
            pst.setInt(4, aluno.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    /**
     * Remove o código do departamento do SGBD.
     *
     * @param dept Departamento a ser excluído. Necessita apenas do atributo COD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public void delete(Aluno aluno) throws SQLException {
        String sql = "DELETE FROM DEPARTAMENTO WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, aluno.getCod());
        pst.executeUpdate();
        pst.close();
    }

    /**
     * Retorna uma Lista com todos os Departamentos cadastrados no SGBD.
     *
     * @return Lista com os departamentos.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco
     * será devolvido nesta Exceção
     */
    public List<Aluno> listaTodos() throws SQLException {
        List<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT COD,NOME,ENDERECO,TELEFONE FROM DEPARTAMENTO ORDER BY COD";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Aluno aluno = new Aluno(rs.getInt("COD"), rs.getString("NOME"), rs.getString("ENDERECO"), rs.getInt("TELEFONE"));
            lista.add(aluno);
        }
        rs.close();
        st.close();
        return lista;
    }

    /**
     * Aplica os testes para as regras de negócio.
     *
     * @param dept Departamento a ser testado
     * @return true se o Departamento atende as regras de negócio, ou false em
     * caso contrário.
     */
    
    public boolean valida(Aluno aluno) {
        boolean ret = false;
        if (aluno != null) {
            ret = true;
        }
        return ret;
    }
}
