package com.group12B.maven.classes;

import java.util.ArrayList;

public class SugestaoRefeicao {
    private int idUtilizador;
    private String nome;
    private ArrayList<Alimento> alimentos;
    private String comentario;
    private int avaliacao; // de 0 a 5 (0 se não comeu)

    public SugestaoRefeicao(int idUtilizador, String nome) {
        this.idUtilizador = idUtilizador;
        this.nome = nome;
        this.alimentos = new ArrayList<>();
    }

    // Getters
    public int getIdUtilizador() {
        return idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public String getComentario() {
        return comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    // Setters
    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}
