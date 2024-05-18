package com.group12B.maven.classes;

public class Alimento {
    private String nome;
    private int calorias;
    private int proteinas;
    private int carboidratos;
    private int gorduras;

    public Alimento(String nome, int calorias, int proteinas, int carboidratos, int gorduras) {
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

    public int getCalorias() {
        return calorias;
    }

    public int getProteinas() {
        return proteinas;
    }

    public int getCarboidratos() {
        return carboidratos;
    }

    public int getGorduras() {
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
