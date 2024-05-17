package com.group12B.maven.classes;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gestor {
	ArrayList<Admin> admins;
    String filePath;
    ArrayList<Alimento> alimentos;

    public Gestor(String filePath) throws IOException, CsvValidationException {
        this.filePath = filePath;
        this.admins = new ArrayList<>();
        this.alimentos = new ArrayList<>();
        loadAlimentosFromCSV();
    }

    private void loadAlimentosFromCSV() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase("nome")) {
                    continue; // Skip header row
                }
                String nome = line[0];
                int calorias = Integer.parseInt(line[1]);
                int proteinas = Integer.parseInt(line[2]);
                int carboidratos = Integer.parseInt(line[3]);
                int gorduras = Integer.parseInt(line[4]);

                Alimento alimento = new Alimento(nome, calorias, proteinas, carboidratos, gorduras);
                alimentos.add(alimento);
            }
        }
    }
    
    public void registoUtilizador(User utilizador) {
        
    }

    public boolean loginUtilizador(String nome, String senha) {
        
        return false;
    }

    public void adicionarRefeicao(Refeicao refeicao) {
       
    }

    public void consultarRefeicoes() {
        
    }

    public void consultarDadosNutricionaisComparadosMeta() {
        
    }

    public void sugestaoRefeicoes() {
        
    }

    public void consultarCaloriasAlimento(String nomeAlimento) {
        for (Alimento alimento : alimentos) {
            if (alimento.nome.equalsIgnoreCase(nomeAlimento)) {
                System.out.println("Calorias: " + alimento.calorias);
                System.out.println("Proteínas: " + alimento.proteinas);
                System.out.println("Carboidratos: " + alimento.carboidratos);
                System.out.println("Gorduras: " + alimento.gorduras);
            }
        }
    }

    public void logout() {
        
    }

    public void fecharDia() {
        
    }

    public void mudarDadosNutricionaisAlimentos() {
        
    }

    public void consultarUtilizadores() {
       
    }

    public void mudarCargoUtilizador(int id, String novoCargo) {
      
    }

    public void fechar() {
        
    }
}
