/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.bean;

/**
 *
 * @author leomarotta
 */
public class Matricula {
    private int cod;
    private Disciplina disciplina;
    private Aluno aluno;
    private String nome;
    
    public Matricula(){
    }
    
    public Matricula(int cod){
        this.cod = cod;
    }    

    public Matricula(int cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }
    
    public Matricula(int cod, String nome, Disciplina disciplina, Aluno aluno){
        this.cod = cod;
        this.nome = nome;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.cod;
        return hash;
    }
}
