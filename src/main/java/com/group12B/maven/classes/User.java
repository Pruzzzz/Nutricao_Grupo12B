package com.group12B.maven.classes;

import java.util.ArrayList;

public class User extends Admin{
    int idade;
    double peso;
    double altura;
    String genero;
    int caloriasDiariasIngeridas;
    int proteinasDiariasIngeridas;
    int carboidratosDiariosIngeridas;
    int gordurasDiariasIngeridas;
    ArrayList<SugestaoRefeicao> sugestoes;

    public User(int id, String nome, String senha, int idade, double peso, double altura, String genero) {
        super(id, nome, senha);
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.sugestoes = new ArrayList<>();
    }
}

