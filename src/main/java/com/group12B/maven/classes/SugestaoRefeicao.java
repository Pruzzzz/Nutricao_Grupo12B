package com.group12B.maven.classes;

import java.util.ArrayList;

public class SugestaoRefeicao {
	int idUtilizador;
    String nome;
    ArrayList<Alimento> alimentos;
    String comentario;
    int avaliacao; // de 0 a 5 (0 se não comeu)

    public SugestaoRefeicao(int idUtilizador, String nome) {
        this.idUtilizador = idUtilizador;
        this.nome = nome;
        this.alimentos = new ArrayList<>();
    }

}
