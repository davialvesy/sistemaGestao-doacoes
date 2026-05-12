// Created by Ana, and Gabriel
package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import java.time.LocalDateTime;
public class Doador extends Usuario {
    private String cpf;
    
    public Doador(int id, String nome, String senha, String email,LocalDateTime dataCadastro,String cpf ){
        super(id, nome, senha, email, dataCadastro);
        setCpf(cpf);
    }
     public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(validarCpf(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    private boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}