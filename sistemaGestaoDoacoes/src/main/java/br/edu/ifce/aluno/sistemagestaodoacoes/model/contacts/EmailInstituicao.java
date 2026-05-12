package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;

import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Usuario;

public class EmailInstituicao {

    private int idEmail;
    private String email;
    private Instituicao instituicao;

    public EmailInstituicao(int idEmail, String email, Instituicao instituicao) {

        this.idEmail = idEmail;
        setEmail(email);
        setInstituicao(instituicao);
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

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {

        if(instituicao != null) {
            this.instituicao = instituicao;
        } else {
            throw new IllegalArgumentException("Instituição inválida.");
        }
    }
}