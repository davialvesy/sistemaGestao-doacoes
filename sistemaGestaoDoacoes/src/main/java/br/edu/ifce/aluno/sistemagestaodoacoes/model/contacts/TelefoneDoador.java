// Created by Ana

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;

public class TelefoneDoador {
    private int idTelefone;
    private String numTelefone;
    private Doador doador;

    public TelefoneDoador(int idTelefone, String numTelefone, Doador doador) {
        this.idTelefone = idTelefone;
        setNumTelefone(numTelefone);
        this.doador = doador;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        if(numTelefone != null && numTelefone.matches("\\d{10,11}")) {
            this.numTelefone = numTelefone;
        } else {
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        if(doador != null) {
            this.doador = doador;
        } else {
            throw new IllegalArgumentException("Doador inválido.");
        }
    }
}
