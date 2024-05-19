package com.group12B.maven.classes;

import java.util.ArrayList;

public class RegistoAlimentar {
    private int idUtilizador;
    private ArrayList<Refeicao> refeicoes;

    public RegistoAlimentar(int idUtilizador) {
        this.idUtilizador = idUtilizador;
        this.refeicoes = new ArrayList<>();
    }

    // Getters
    public int getIdUtilizador() {
        return idUtilizador;
    }


    public ArrayList<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    // Setters
    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public void setRefeicoes(ArrayList<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
    
    public void nvRefeicao(Refeicao refeicao)
    {
    	refeicoes.add(refeicao);
    }
}
