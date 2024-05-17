package com.group12B.maven.classes;

import java.util.ArrayList;

public class Refeicao {
	int refeicaoId;
    String nome;
    ArrayList<Alimento> alimentos;

    public Refeicao(int refeicaoId, String nome) {
        this.refeicaoId = refeicaoId;
        this.nome = nome;
        this.alimentos = new ArrayList<>();
    }
}
