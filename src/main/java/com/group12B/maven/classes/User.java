package com.group12B.maven.classes;

import java.util.ArrayList;

public class User extends Admin {
    private int idade;
    private double peso;
    private double altura;
    private String genero;
    private ArrayList<Refeicao> refeicoes;

    public User(int id, String nome, String senha, int idade, double peso, double altura, String genero) {
        super(id, nome, senha);
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.refeicoes = new ArrayList<>();
    }

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

    public void registarRef(Refeicao refeicao) {
        refeicoes.add(refeicao);
    }

    public void getRegisto() {
        for (Refeicao refeicao : refeicoes) {
            System.out.println("Refeição: " + refeicao.getNome() + ", Data: " + refeicao.getData());
        }
    }

	public ArrayList<Refeicao> getRefeicoes() {
		return refeicoes;
	}

}
