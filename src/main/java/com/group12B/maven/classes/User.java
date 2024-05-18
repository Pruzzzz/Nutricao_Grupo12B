package com.group12B.maven.classes;

import java.util.ArrayList;

public class User extends Admin {
    private int idade;
    private double peso;
    private double altura;
    private String genero;
    private int caloriasDiariasIngeridas;
    private int proteinasDiariasIngeridas;
    private int carboidratosDiariosIngeridas;
    private int gordurasDiariasIngeridas;
    private ArrayList<SugestaoRefeicao> sugestoes;

    public User(int id, String nome, String senha, int idade, double peso, double altura, String genero) {
        super(id, nome, senha);
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.sugestoes = new ArrayList<>();
    }

    // Getters
    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getGenero() {
        return genero;
    }

    public int getCaloriasDiariasIngeridas() {
        return caloriasDiariasIngeridas;
    }

    public int getProteinasDiariasIngeridas() {
        return proteinasDiariasIngeridas;
    }

    public int getCarboidratosDiariosIngeridas() {
        return carboidratosDiariosIngeridas;
    }

    public int getGordurasDiariasIngeridas() {
        return gordurasDiariasIngeridas;
    }

    public ArrayList<SugestaoRefeicao> getSugestoes() {
        return sugestoes;
    }

    // Setters
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCaloriasDiariasIngeridas(int caloriasDiariasIngeridas) {
        this.caloriasDiariasIngeridas = caloriasDiariasIngeridas;
    }

    public void setProteinasDiariasIngeridas(int proteinasDiariasIngeridas) {
        this.proteinasDiariasIngeridas = proteinasDiariasIngeridas;
    }

    public void setCarboidratosDiariosIngeridas(int carboidratosDiariosIngeridas) {
        this.carboidratosDiariosIngeridas = carboidratosDiariosIngeridas;
    }

    public void setGordurasDiariasIngeridas(int gordurasDiariasIngeridas) {
        this.gordurasDiariasIngeridas = gordurasDiariasIngeridas;
    }
}
