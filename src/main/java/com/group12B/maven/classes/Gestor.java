package com.group12B.maven.classes;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gestor {
	private ArrayList<Admin> admins;
	private String filePathAlimentos;
    private  String filePathLogin;
    private ArrayList<Alimento> alimentos;

    public Gestor(String filePathAlimentos, String filePathLogin) throws IOException, CsvValidationException {
        this.filePathAlimentos = filePathAlimentos;
        this.filePathLogin = filePathLogin;
        this.admins = new ArrayList<>();
        this.alimentos = new ArrayList<>();
        loadAlimentosFromCSV();
        loadAdminsFromCSV();
    }
	

    private void loadAlimentosFromCSV() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePathAlimentos))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase("nome")) {
                    continue; // passsar a linha 1
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
    
    private void loadAdminsFromCSV() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePathLogin))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase("id")) {
                    continue; //passar primeira linha
                }
                int id = Integer.parseInt(line[0]);
                String nome = line[1];
                String senha = line[2];

                Admin admin = new Admin(id, nome, senha);
                admins.add(admin);
            }
        }
    }

    
    public void registoUtilizador(int id, String nome, String senha, int idade, double peso, double altura, String genero) {
        Admin user = new User(id,nome,senha,idade,peso,altura,genero);
        admins.add(user);
    }

    public boolean loginUtilizador(int id, String senha) {
        for (Admin admin : admins) {
            if (admin.getId() == id && admin.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean loginAdmin(int id, String senha) {
        for (Admin admin : admins) {
            if (admin.getId() == id && admin.getSenha().equals(senha)) {
                return true;
            }
        }
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
            if (alimento.getNome().equalsIgnoreCase(nomeAlimento)) {
                System.out.println("Calorias: " + alimento.getCalorias());
                System.out.println("Proteínas: " + alimento.getProteinas());
                System.out.println("Carboidratos: " + alimento.getCarboidratos());
                System.out.println("Gorduras: " + alimento.getGorduras());
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

    public void mudarCargoUtilizador() {
      
    }

    public void fechar() {
        
    }
}
