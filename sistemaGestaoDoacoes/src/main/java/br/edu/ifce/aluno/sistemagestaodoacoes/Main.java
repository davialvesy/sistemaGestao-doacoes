// Created by Davi, and Vinicius

package br.edu.ifce.aluno.sistemagestaodoacoes;

import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doacao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Doador> doadores = new ArrayList<>();
        ArrayList<Instituicao> instituicoes = new ArrayList<>();
        ArrayList<Doacao> doacoes = new ArrayList<>();

        int opcao;

        do { // Tela interativa simples
            System.out.println("\n===== SISTEMA DE DOAÇÕES =====");
            System.out.println("1 - Cadastrar doador");
            System.out.println("2 - Cadastrar instituição");
            System.out.println("3 - Realizar doação");
            System.out.println("4 - Listar doadores");
            System.out.println("5 - Listar instituições");
            System.out.println("6 - Listar doações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());
            try {
                switch (opcao) {
                    case 1:
                        System.out.println("\n===Cadastrando Doador===");
                        System.out.print("Nome: ");
                        String nomeDoador = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senhaDoador = scanner.nextLine();

                        System.out.print("Email: ");
                        String emailDoador = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        Doador doador = new Doador(
                                doadores.size() + 1,
                                nomeDoador,
                                senhaDoador,
                                emailDoador,
                                LocalDateTime.now(),
                                cpf
                        );

                        doadores.add(doador);

                        System.out.println("Doador cadastrado com sucesso!");

                        break;

                    case 2:
                        System.out.println("\n=== Cadastro de Instituição ===");

                        System.out.print("Nome: ");
                        String nomeInst = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senhaInst = scanner.nextLine();

                        System.out.print("Email: ");
                        String emailInst = scanner.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        Instituicao instituicao = new Instituicao(
                                instituicoes.size() + 1,
                                nomeInst,
                                senhaInst,
                                emailInst,
                                LocalDateTime.now(),
                                0,
                                cnpj
                        );

                        instituicoes.add(instituicao);

                        System.out.println("\nInstituição cadastrada com sucesso!");

                        break;

                    case 3:
                        if (doadores.isEmpty() || instituicoes.isEmpty()) {
                            System.out.println("Necessário possuir doadores e instituições cadastradas.");
                            break;
                        }

                        System.out.println("\n=== DOADORES ===");

                        for (int i = 0; i < doadores.size(); i++) {
                            System.out.println(i + " - " + doadores.get(i).getNome());
                        }

                        System.out.print("Escolha o doador: ");
                        int indiceDoador = Integer.parseInt(scanner.nextLine());

                        System.out.println("\n=== INSTITUIÇÕES ===");

                        for (int i = 0; i < instituicoes.size(); i++) {
                            System.out.println(i + " - " + instituicoes.get(i).getNome());
                        }

                        System.out.print("Escolha a instituição: ");
                        int indiceInstituicao = Integer.parseInt(scanner.nextLine());

                        System.out.print("Valor da doação: ");
                        double valor = Double.parseDouble(scanner.nextLine());

                        Doacao doacao = new Doacao(
                                doacoes.size() + 1,
                                doadores.get(indiceDoador),
                                instituicoes.get(indiceInstituicao),
                                valor
                        );

                        doacoes.add(doacao);

                        System.out.println("Doação realizada com sucesso!");

                        break;

                    case 4:
                        System.out.println("\n=== DOADORES ===");

                        if(doadores.isEmpty()){System.out.println("Nenhum doador cadastrado.");}

                        for (Doador d : doadores) {
                            System.out.println(
                                    "ID: " + d.getCpf() +
                                            " | Nome: " + d.getNome()
                            );
                        }

                        break;

                    case 5:
                        System.out.println("\n=== INSTITUIÇÕES ===");

                        if(instituicoes.isEmpty()) {System.out.println("Não há nenhuma instituicão cadastrada");}
                        for (Instituicao i : instituicoes) {
                            System.out.println(
                                    "Nome: " + i.getNome() +
                                            " | Arrecadação: R$ " + i.getArrecadacao()
                            );
                        }

                        break;

                    case 6:
                        System.out.println("\n=== DOAÇÕES ===");

                        if(doacoes.isEmpty()){System.out.println("Nenhuma doação realizada.");}

                        for (Doacao d : doacoes) {

                            System.out.println(
                                    "Doador: " + d.getDoador().getNome() +
                                            " | Instituição: " + d.getInstituicao().getNome() +
                                            " | Valor: R$ " + d.getQuantiaDoada()
                            );
                        }

                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");

                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {

                System.out.println("Entrada inválida.");
            }
        } while(opcao!=0);

        scanner.close();
    }
}