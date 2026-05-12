// Created by Ana

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Usuario;
public class EmailDoador {
    private int idEmail;
    private String email;
    private Doador doador;

    public EmailDoador(int idEmail, String email, Doador doador) {
        this.idEmail = idEmail;
        setEmail(email);
        setDoador(doador);
    }

    public int getIdEmail() {
        return idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(Usuario.validacaoEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido.");
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