package com.group12B.maven.classes;

import java.util.ArrayList;
import java.time.LocalDate;

public class Refeicao {
    private int refeicaoId;
    private String nome;
    private ArrayList<Alimento> alimentos;
    private LocalDate data;

    public Refeicao(int refeicaoId, String nome) {
        this.refeicaoId = refeicaoId;
        this.nome = nome;
        this.alimentos = new ArrayList<>();
        data = LocalDate.now();
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
    
    public LocalDate getData() {
    	return data;
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
