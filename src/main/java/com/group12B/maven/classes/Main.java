package com.group12B.maven.classes;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        Scanner scanner = new Scanner(System.in);
        String pathAlimento = "/home/pruz/git/repository/Grupo12B-maven/alimentos.csv";
        String pathLogin = "/home/pruz/git/repository/Grupo12B-maven/login.csv";
        Gestor gestor = new Gestor(pathAlimento, pathLogin);

        while (true) {
            System.out.println("Menu:");
            if (gestor.getCurrentUser() == null) {
                System.out.println("1. Registrar Utilizador");
                System.out.println("2. Login Utilizador");
                System.out.println("3. Login Admin");
                System.out.println("10. Sair");
            } else {
                System.out.println("4. Adicionar Refeição");
                System.out.println("5. Consultar Refeições");
                System.out.println("6. Consultar Calorias de Alimento");
                System.out.println("7. Sugestão de Refeições");
                System.out.println("8. Logout");
                System.out.println("9. Calorias Consumidas e Restantes");
                System.out.println("10. Sair");
            }
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline

            switch (opcao) {
                case 1:
                    System.out.print("ID (deve ser maior que 1): ");
                    int idReg = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline
                    if (idReg <= 1) {
                        System.out.println("ID inválido. Deve ser maior que 1.");
                        break;
                    }
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaReg = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline
                    System.out.print("Peso: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine(); // consume the leftover newline
                    System.out.print("Altura: ");
                    double altura = scanner.nextDouble();
                    scanner.nextLine(); // consume the leftover newline
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    gestor.registoUtilizador(idReg, nome, senhaReg, idade, peso, altura, genero);
                    System.out.println("Utilizador registrado com sucesso.");
                    break;
                case 2:
                    System.out.print("ID: ");
                    int idUserLogin = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline

                    System.out.print("Senha: ");
                    String senhaUser = scanner.nextLine();

                    if (gestor.loginUtilizador(idUserLogin, senhaUser)) {
                        System.out.println("Login de utilizador bem-sucedido.");
                    } else {
                        System.out.println("ID ou senha incorretos.");
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    int idAdmin = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline

                    System.out.print("Senha: ");
                    String senhaAdmin = scanner.nextLine();

                    if (gestor.loginAdmin(idAdmin, senhaAdmin)) {
                        System.out.println("Login de admin bem-sucedido.");
                    } else {
                        System.out.println("ID ou senha incorretos.");
                    }
                    break;
                case 4:
                    if (gestor.getCurrentUser() == null) {
                        System.out.println("Por favor, faça login primeiro.");
                        break;
                    }
                    System.out.print("ID da Refeição: ");
                    int idRef = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline

                    System.out.print("Nome da Refeição: ");
                    String nomeRef = scanner.nextLine();

                    Refeicao refeicao = new Refeicao(idRef, nomeRef);

                    boolean adicionarAlimentos = true;
                    while (adicionarAlimentos) {
                        System.out.print("Nome do Alimento: ");
                        String nomeAlimento = scanner.nextLine();
                        Alimento alimento = null;
                        for (Alimento a : gestor.getAlimentos()) {
                            if (a.getNome().equalsIgnoreCase(nomeAlimento)) {
                                alimento = a;
                                break;
                            }
                        }
                        if (alimento != null) {
                            refeicao.getAlimentos().add(alimento);
                        } else {
                            System.out.println("Alimento não encontrado.");
                        }
                        System.out.print("Deseja adicionar mais alimentos? (sim/não): ");
                        String resposta = scanner.nextLine();
                        adicionarAlimentos = resposta.equalsIgnoreCase("sim");
                    }

                    gestor.adicionarRefeicao(refeicao, gestor.getCurrentUser().getId());
                    System.out.println("Refeição adicionada com sucesso.");
                    break;
                case 5:
                    if (gestor.getCurrentUser() == null) {
                        System.out.println("Por favor, faça login primeiro.");
                        break;
                    }
                    gestor.consultarRefeicoes(gestor.getCurrentUser().getId());
                    break;
                case 6:
                    if (gestor.getCurrentUser() == null) {
                        System.out.println("Por favor, faça login primeiro.");
                        break;
                    }
                    System.out.print("Nome do Alimento: ");
                    String nomeAlimento = scanner.next();
                    gestor.consultarCaloriasAlimento(nomeAlimento);
                    break;
                case 7:
                    if (gestor.getCurrentUser() == null) {
                        System.out.println("Por favor, faça login primeiro.");
                        break;
                    }
                    if (gestor.getCurrentUser() instanceof User) {
                        Refeicao refeicaoSugerida = gestor.sugerirRefeicao();
                        if (refeicaoSugerida != null) {
                            System.out.println("Refeição sugerida:");
                            for (Alimento alimento : refeicaoSugerida.getAlimentos()) {
                                System.out.println(alimento.getNome());
                            }
                            System.out.print("Deseja comer esta refeição? (sim/não): ");
                            String resposta = scanner.nextLine();
                            if (resposta.equalsIgnoreCase("sim")) {
                                gestor.adicionarRefeicao(refeicaoSugerida, gestor.getCurrentUser().getId());
                                System.out.println("Refeição adicionada com sucesso.");
                            } else {
                                System.out.println("Refeição não adicionada.");
                            }
                        } else {
                            System.out.println("Não foi possível sugerir uma refeição equilibrada.");
                        }
                    } else {
                        System.out.println("Somente utilizadores podem receber sugestões de refeições.");
                    }
                    break;
                case 8:
                    gestor.logout();
                    System.out.println("Logout bem-sucedido.");
                    break;
                case 9:
                    if (gestor.getCurrentUser() == null) {
                        System.out.println("Por favor, faça login primeiro.");
                        break;
                    }
                    if (gestor.getCurrentUser() instanceof User) {
                        User currentUser = (User) gestor.getCurrentUser();
                        double caloriasConsumidas = gestor.calcularCaloriasConsumidas(currentUser.getId());
                        double caloriasTotais = gestor.calcularCaloriasDiarias(currentUser);
                        double caloriasRestantes = caloriasTotais - caloriasConsumidas;
                        System.out.println("Calorias Consumidas: " + caloriasConsumidas);
                        System.out.println("Calorias Restantes: " + caloriasRestantes);
                    } else {
                        System.out.println("Calorias consumidas e restantes só podem ser calculadas para utilizadores.");
                    }
                    break;
                case 10:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}