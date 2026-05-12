package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;

import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;

public class TelefoneInstituicao {

    private int idTelefone;
    private String numTelefone;
    private Instituicao instituicao;

    public TelefoneInstituicao(int idTelefone,
                               String numTelefone,
                               Instituicao instituicao) {

        this.idTelefone = idTelefone;
        setNumTelefone(numTelefone);
        setInstituicao(instituicao);
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {

        if(numTelefone != null &&
           numTelefone.matches("\\d{10,11}")) {

            this.numTelefone = numTelefone;

        } else {
            throw new IllegalArgumentException("Telefone inválido.");
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