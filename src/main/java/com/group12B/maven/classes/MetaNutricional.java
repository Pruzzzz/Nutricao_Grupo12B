package com.group12B.maven.classes;

public class MetaNutricional {
    private int idUtilizador;
    private int caloriasDiariasMeta;
    private int proteinasDiariasMeta;
    private int carboidratosDiariasMeta;
    private int gordurasDiariasMeta;

    public MetaNutricional(int idUtilizador, int caloriasDiariasMeta, int proteinasDiariasMeta, int carboidratosDiariasMeta, int gordurasDiariasMeta) {
        this.idUtilizador = idUtilizador;
        this.caloriasDiariasMeta = caloriasDiariasMeta;
        this.proteinasDiariasMeta = proteinasDiariasMeta;
        this.carboidratosDiariasMeta = carboidratosDiariasMeta;
        this.gordurasDiariasMeta = gordurasDiariasMeta;
    }

    // Getters
    public int getIdUtilizador() {
        return idUtilizador;
    }

    public int getCaloriasDiariasMeta() {
        return caloriasDiariasMeta;
    }

    public int getProteinasDiariasMeta() {
        return proteinasDiariasMeta;
    }

    public int getCarboidratosDiariasMeta() {
        return carboidratosDiariasMeta;
    }

    public int getGordurasDiariasMeta() {
        return gordurasDiariasMeta;
    }

    // Setters
    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public void setCaloriasDiariasMeta(int caloriasDiariasMeta) {
        this.caloriasDiariasMeta = caloriasDiariasMeta;
    }

    public void setProteinasDiariasMeta(int proteinasDiariasMeta) {
        this.proteinasDiariasMeta = proteinasDiariasMeta;
    }

    public void setCarboidratosDiariasMeta(int carboidratosDiariasMeta) {
        this.carboidratosDiariasMeta = carboidratosDiariasMeta;
    }

    public void setGordurasDiariasMeta(int gordurasDiariasMeta) {
        this.gordurasDiariasMeta = gordurasDiariasMeta;
    }
}