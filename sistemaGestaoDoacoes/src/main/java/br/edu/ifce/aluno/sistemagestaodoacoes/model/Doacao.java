// Created by Ana
package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import java.time.LocalDateTime;
public class Doacao {
    private int idDoacao;
    private Doador doador;
    private Instituicao instituicao;
    private double quantiaDoada;
    private LocalDateTime dataDoacao;

    public Doacao(int idDoacao, Doador doador,
                   Instituicao instituicao, double quantiaDoada) {

        this.idDoacao = idDoacao;
        this.doador = doador;
        this.instituicao = instituicao;
        setQuantiaDoada(quantiaDoada);
        this.dataDoacao = LocalDateTime.now();

        instituicao.adicionarDoacao(quantiaDoada);
    }

    public int getIdDoacao() {
        return idDoacao;
    }

    public Doador getDoador() {
        return doador;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public double getQuantiaDoada() {
        return quantiaDoada;
    }

    public void setQuantiaDoada(double quantiaDoada) {
        if(quantiaDoada > 0) {
            this.quantiaDoada = quantiaDoada;
        } else {
            throw new IllegalArgumentException("Valor da doação inválido.");
        }
    }

    public LocalDateTime getDataDoacao() {
        return dataDoacao;
    }
}