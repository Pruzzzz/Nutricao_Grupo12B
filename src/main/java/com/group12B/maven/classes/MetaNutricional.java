package com.group12B.maven.classes;

public class MetaNutricional {
	int idUtilizador;
    int caloriasDiariasMeta;
    int proteinasDiariasMeta;
    int carboidratosDiariasMeta;
    int gordurasDiariasMeta;

    public MetaNutricional(int idUtilizador, int caloriasDiariasMeta, int proteinasDiariasMeta, int carboidratosDiariasMeta, int gordurasDiariasMeta) {
        this.idUtilizador = idUtilizador;
        this.caloriasDiariasMeta = caloriasDiariasMeta;
        this.proteinasDiariasMeta = proteinasDiariasMeta;
        this.carboidratosDiariasMeta = carboidratosDiariasMeta;
        this.gordurasDiariasMeta = gordurasDiariasMeta;
    }

}
