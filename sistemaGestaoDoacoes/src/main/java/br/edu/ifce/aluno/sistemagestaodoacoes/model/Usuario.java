// Created by Davi
package br.edu.ifce.aluno.sistemagestaodoacoes.model;

import java.time.LocalDateTime;

public abstract class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private LocalDateTime dataCadastro;

    public Usuario(int id, String nome, String senha, String email, LocalDateTime dataCadastro) {
        this.id = id;
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        this.dataCadastro = LocalDateTime.now(); // A data do cadastro deve ser automática
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(validacaoNome(nome)) {
            this.nome = nome.trim();
        } else {
            throw new IllegalArgumentException("Nome Inválido.");
        }
    }

    public String getSenha() {return senha;}

    public void setSenha(String senha) {
        if(validacaoSenha(senha)){
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("Senha Iválida.");
        }
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        if(validacaoEmail(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    public static boolean validacaoSenha(String senha) {
        if(senha==null){return false;} // Verifica se a senha aponta para null

        senha = senha.trim(); // Desconsidera espaços no inicio e fim

        if(senha.isEmpty() || senha.length()<12){return false;}
        // Veirica se a senha está vazia, ou possui menos de 12 caracteres

        // Passa algumas métricas para deixar a senhas mais "forte"
        // Métricas como letras minusculas, maisculas, simbolos e números
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;
        for(int i=0; i<senha.length(); i++) {
            char c = senha.charAt(i);

            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            } // Verifica se é maiúscula
            else if (Character.isLowerCase(c)) {
                temMinuscula = true;
            } // Verifica é minuscula
            else if (Character.isDigit(c)) {
                temNumero = true;
            } // Verifica se é um digito
            else {
                temEspecial = true;
            } // Verifica se é um simbolo
        }
        return temEspecial && temMaiuscula && temMinuscula && temNumero;
    }

    public static boolean validacaoEmail(String email) {
        if(email==null) {return false;} // Veririfica se email não está apontando para null

        email = email.trim(); // Desconsidera espaços no inicio e final

        if(email.isEmpty()) {return false;} // Veririca se email é vazio

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // Especifica o formato padrão de email
        // Formato: usuario@dominio

        return email.matches(regex);
    }

    public static boolean validacaoNome(String nome) {
        if(nome==null) {return false;}

        nome = nome.trim(); // Remove espaços no inicio e fim da String

        if(nome.isEmpty() || nome.length()<2) {return false;}
        // Verifica se é vazio, ou se possui tamanho menor que 2 caracteres

        for(int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);
            // Armazena caractere em c

            if(!Character.isLetter(c) && c != ' ') {
                return false;
            } // Veririca se há algum simbolo não permitido
        }
        return true;
    }
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}