package com.example.joaod.escolaaprendabrincando;

/**
 * Created by joaod on 22/11/2016.
 */

public class Calendario {
    private String titulo;
    private String inicio;
    private String fim;
    private String professor;
    private String nomeTurma;
    private String ambiente;

    public Calendario() {
    }

    public Calendario(String titulo, String inicio, String fim, String professor, String nomeTurma, String ambiente) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fim = fim;
        this.professor = professor;
        this.nomeTurma = nomeTurma;
        this.ambiente = ambiente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    @Override
    public String toString() {
        return "\n" + titulo + "\n" + inicio + "\n" + fim + "\n" + professor + "\n" + nomeTurma + "\n" + ambiente + "\n";
    }


}
