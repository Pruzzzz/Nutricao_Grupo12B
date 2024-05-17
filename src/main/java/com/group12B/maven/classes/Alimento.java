package com.group12B.maven.classes;

public class Alimento {
	String nome;
    int calorias;
    int proteinas;
    int carboidratos;
    int gorduras;

    public Alimento(String nome, int calorias, int proteinas, int carboidratos, int gorduras) {
        this.nome = nome;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
    }

}
