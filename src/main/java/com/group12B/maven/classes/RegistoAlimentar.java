package com.group12B.maven.classes;

import java.util.ArrayList;
import java.util.Date;

public class RegistoAlimentar {
    private int idUtilizador;
    private Date data;
    private ArrayList<Refeicao> refeicoes;

    public RegistoAlimentar(int idUtilizador, Date data) {
        this.idUtilizador = idUtilizador;
        this.data = data;
        this.refeicoes = new ArrayList<>();
    }

    // Getters
    public int getIdUtilizador() {
        return idUtilizador;
    }

    public Date getData() {
        return data;
    }

    public ArrayList<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    // Setters
    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setRefeicoes(ArrayList<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
}
