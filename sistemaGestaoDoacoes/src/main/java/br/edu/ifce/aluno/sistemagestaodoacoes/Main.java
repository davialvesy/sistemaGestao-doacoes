package br.edu.ifce.aluno.sistemagestaodoacoes;

import java.time.LocalDateTime;

import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doacao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts.EmailDoador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts.EmailInstituicao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts.TelefoneDoador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts.TelefoneInstituicao;

public class Main {

    public static void main(String[] args) {

        // Criando doador
        Doador doador = new Doador(
                1,
                "Carlos Silva",
                "Senha@123456",
                "carlos@gmail.com",
                LocalDateTime.now(),
                "12345678901"
        );

        // Criando instituição
        Instituicao instituicao = new Instituicao(
                1,
                "Instituto Esperanca",
                "Instituto@123",
                "contato@esperanca.com",
                LocalDateTime.now(),
                0,
                "12345678000199"
        );

        // Criando email do doador
        EmailDoador emailDoador = new EmailDoador(
                1,
                "carlos.contato@gmail.com",
                doador
        );

        // Criando telefone do doador
        TelefoneDoador telefoneDoador = new TelefoneDoador(
                1,
                "88999999999",
                doador
        );

        // Criando email da instituição
        EmailInstituicao emailInstituicao = new EmailInstituicao(
                1,
                "ajuda@esperanca.com",
                instituicao
        );

        // Criando telefone da instituição
        TelefoneInstituicao telefoneInstituicao = new TelefoneInstituicao(
                1,
                "8833334444",
                instituicao
        );

        // Criando doação
        Doacao doacao = new Doacao(
                1,
                doador,
                instituicao,
                250.00
        );

        // Exibindo informações
        System.out.println("===== Doador =====");
        System.out.println("Nome: " + doador.getNome());
        System.out.println("CPF: " + doador.getCpf());
        System.out.println("Email: " + emailDoador.getEmail());
        System.out.println("Telefone: " + telefoneDoador.getNumTelefone());

        System.out.println("\n===== Instituição =====");
        System.out.println("Nome: " + instituicao.getNome());
        System.out.println("CNPJ: " + instituicao.getCnpj());
        System.out.println("Email: " + emailInstituicao.getEmail());
        System.out.println("Telefone: " + telefoneInstituicao.getNumTelefone());

        System.out.println("\n===== Doação =====");
        System.out.println("ID Doação: " + doacao.getIdDoacao());
        System.out.println("Valor doado: R$ " + doacao.getQuantiaDoada());
        System.out.println("Data: " + doacao.getDataDoacao());

        System.out.println("\n===== Arrecadação =====");
        System.out.println("Total arrecadado pela instituição: R$ "
                + instituicao.getArrecadacao());

        // Testando autenticação
        System.out.println("\n===== Autenticação =====");
        System.out.println(doador.autenticar("Senha@123456")
        );
    }
}
