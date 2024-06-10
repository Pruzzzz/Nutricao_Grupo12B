package com.group12B.maven.classes;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Gestor {
    private ArrayList<Admin> admins;
    private String filePathAlimentos;
    private String filePathLogin;
    private ArrayList<Alimento> alimentos;
    private Admin currentUser;

    public Gestor(String filePathAlimentos, String filePathLogin) throws IOException, CsvValidationException {
        this.filePathAlimentos = filePathAlimentos;
        this.filePathLogin = filePathLogin;
        this.admins = new ArrayList<>();
        this.alimentos = new ArrayList<>();
        loadAlimentosFromCSV();
        loadAdminsFromCSV();
        this.currentUser = null;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public Admin getCurrentUser() {
        return currentUser;
    }

    private void loadAlimentosFromCSV() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePathAlimentos))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase("nome")) {
                    continue; // Skip header line
                }
                try {
                    String nome = line[0];
                    double calorias = Double.parseDouble(line[1]);
                    double proteinas = Double.parseDouble(line[2]);
                    double carboidratos = Double.parseDouble(line[3]);
                    double gorduras = Double.parseDouble(line[4]);

                    Alimento alimento = new Alimento(nome, calorias, proteinas, carboidratos, gorduras);
                    alimentos.add(alimento);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao analisar linha: " + String.join(",", line));
                    System.err.println("Erro: " + e.getMessage());
                }
            }
        }
    }

    private void loadAdminsFromCSV() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePathLogin))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase("id")) {
                    continue; 
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
        Admin user = new User(id, nome, senha, idade, peso, altura, genero);
        admins.add(user);
    }

    public boolean loginUtilizador(int id, String senha) {
        for (Admin admin : admins) {
            if (admin.getId() == id && admin.getSenha().equals(senha)) {
                currentUser = admin;
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(int id, String senha) {
        for (Admin admin : admins) {
            if (admin.getId() == id && admin.getSenha().equals(senha)) {
                currentUser = admin;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public void adicionarRefeicao(Refeicao refeicao, int idUser) {
        if (currentUser != null && currentUser instanceof User) {
            for (Admin user : admins) {
                if (user.getId() == idUser) {
                    ((User) user).registarRef(refeicao);
                }
            }
        } else {
            System.out.println("Operação permitida apenas para utilizadores autenticados.");
        }
    }

    public void consultarRefeicoes(int idUser) {
        if (currentUser != null && currentUser instanceof User) {
            for (Admin user : admins) {
                if (user.getId() == idUser) {
                    ((User) user).getRegisto();
                }
            }
        } else {
            System.out.println("Operação permitida apenas para utilizadores autenticados.");
        }
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

    public double calcularCaloriasDiarias(User user) {
        double bmr;
        if (user.getGenero().equalsIgnoreCase("masculino")) {
            bmr = 88.36 + (13.4 * user.getPeso()) + (4.8 * user.getAltura()) - (5.7 * user.getIdade());
        } else {
            bmr = 447.6 + (9.2 * user.getPeso()) + (3.1 * user.getAltura()) - (4.3 * user.getIdade());
        }
        return bmr * 1.2;
    }

    public double calcularCaloriasConsumidas(int userId) {
        User user = encontrarUtilizador(userId);
        if (user != null) {
            double totalCaloriasConsumidas = 0.0;
            for (Refeicao refeicao : user.getRefeicoes()) {
                for (Alimento alimento : refeicao.getAlimentos()) {
                    totalCaloriasConsumidas += alimento.getCalorias();
                }
            }
            return totalCaloriasConsumidas;
        } else {
            System.out.println("Usuário não encontrado.");
            return 0;
        }
    }


    private User encontrarUtilizador(int userId) {
        for (Admin admin : admins) {
            if (admin instanceof User && admin.getId() == userId) {
                return (User) admin;
            }
        }
        return null;
    }
    
    

    
    public Refeicao sugerirRefeicao() {
        if (alimentos.isEmpty()) {
            System.out.println("Não há alimentos disponíveis para sugerir uma refeição.");
            return null;
        }
        ArrayList<Alimento> carboidratos = new ArrayList<>();
        ArrayList<Alimento> proteinas = new ArrayList<>();
        ArrayList<Alimento> gorduras = new ArrayList<>();

        for (Alimento alimento : alimentos) {
            if (alimento.getCarboidratos() > 0) {
                carboidratos.add(alimento);
            }
            if (alimento.getProteinas() > 0) {
                proteinas.add(alimento);
            }
            if (alimento.getGorduras() > 0) {
                gorduras.add(alimento);
            }
        }

        Alimento alimentoCarboidratos = getRandomAlimento(carboidratos);
        Alimento alimentoProteinas = getRandomAlimento(proteinas);
        Alimento alimentoGorduras = getRandomAlimento(gorduras);

        Refeicao refeicaoSugerida = new Refeicao(1, "Refeição Equilibrada");
        refeicaoSugerida.getAlimentos().add(alimentoCarboidratos);
        refeicaoSugerida.getAlimentos().add(alimentoProteinas);
        refeicaoSugerida.getAlimentos().add(alimentoGorduras);

        return refeicaoSugerida;
    }

    private Alimento getRandomAlimento(ArrayList<Alimento> alimentos) {
        if (alimentos.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return alimentos.get(random.nextInt(alimentos.size()));
    }
}

