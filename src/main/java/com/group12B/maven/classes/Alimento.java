package com.group12B.maven.classes;

public class Alimento {
    private String nome;
    private double calorias;
    private double proteinas;
    private double carboidratos;
    private double gorduras;

    public Alimento(String nome, double calorias, double proteinas, double carboidratos, double gorduras) {
        this.nome = nome;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public double getGorduras() {
        return gorduras;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public void setCarboidratos(int carboidratos) {
        this.carboidratos = carboidratos;
    }

    public void setGorduras(int gorduras) {
        this.gorduras = gorduras;
    }
}
