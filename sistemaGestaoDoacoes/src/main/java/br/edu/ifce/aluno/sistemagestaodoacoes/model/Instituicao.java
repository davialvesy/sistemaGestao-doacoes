// Created by Vinicius, and Gabriel

package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import java.time.LocalDateTime;
public class Instituicao extends Usuario {

    private double arrecadacao;
    private String cnpj;

    public Instituicao(int id, String nome, String senha, String email, LocalDateTime dataCadastro, double arrecadacao, String cnpj) {

        super(id, nome, senha, email, dataCadastro);

        setArrecadacao(arrecadacao);
        setCnpj(cnpj);
    }

    public double getArrecadacao() {
        return arrecadacao;
    }

    public void setArrecadacao(double arrecadacao) {

        if(arrecadacao >= 0) {
            this.arrecadacao = arrecadacao;
        } else {
            throw new IllegalArgumentException("Valor de arrecadação inválido.");
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {

        if(validacaoCnpj(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
    }

    public static boolean validacaoCnpj(String cnpj) {

        if(cnpj == null) {
            return false;
        }

        cnpj = cnpj.trim();

        if(cnpj.isEmpty()) {
            return false;
        }

        cnpj = cnpj.replaceAll("[^0-9]", "");

        return cnpj.length() == 14;
    }

    public void adicionarDoacao(double valor) {
        if(valor > 0) {
            this.arrecadacao += valor;
        } else {
            throw new IllegalArgumentException("Valor da doação inválido.");
        }
    }
}
