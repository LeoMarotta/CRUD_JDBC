/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.bean;

/**
 *
 * @author leomarotta
 */

public class Aluno {
    private int cod;
    private String nome;
    private String endereco;
    private Long telefone;

    public Aluno() {
    }
    
    public Aluno(int cod) {
        this.cod = cod;
    }

    public Aluno(int cod, String nome, String endereco, Long telefone) {
        this.cod = cod;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 4;
        hash = 80 * hash + this.cod;
        return hash;
    }
}
