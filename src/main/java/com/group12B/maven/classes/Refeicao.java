package com.group12B.maven.classes;

import java.util.ArrayList;

public class Refeicao {
    private int refeicaoId;
    private String nome;
    private ArrayList<Alimento> alimentos;

    public Refeicao(int refeicaoId, String nome) {
        this.refeicaoId = refeicaoId;
        this.nome = nome;
        this.alimentos = new ArrayList<>();
    }

    // Getters
    public int getRefeicaoId() {
        return refeicaoId;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    // Setters
    public void setRefeicaoId(int refeicaoId) {
        this.refeicaoId = refeicaoId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
