package com.group12B.maven.classes;

import java.util.ArrayList;
import java.util.Date;

public class RegistoAlimentar {
	int idUtilizador;
    Date data;
    ArrayList<Refeicao> refeicoes;

    public RegistoAlimentar(int idUtilizador, Date data) {
        this.idUtilizador = idUtilizador;
        this.data = data;
        this.refeicoes = new ArrayList<>();
    }

}
