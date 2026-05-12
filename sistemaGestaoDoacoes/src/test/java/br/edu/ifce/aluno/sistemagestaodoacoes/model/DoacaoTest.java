// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class DoacaoTest {

    // =====================================
    // MÉTODOS AUXILIARES
    // =====================================

    private Doador criarDoador() {
        return new Doador(
                1,
                "Carlos Silva",
                "Senha@123456",
                "carlos@gmail.com",
                LocalDateTime.now(),
                "12345678901"
        );
    }

    private Instituicao criarInstituicao() {
        return new Instituicao(
                1,
                "Instituto Esperanca",
                "Senha@123456",
                "instituto@gmail.com",
                LocalDateTime.now(),
                0,
                "12345678000199"
        );
    }

    // =====================================
    // TESTES DO CONSTRUTOR
    // =====================================

    @Test
    void deveCriarDoacaoValida() {
        Doacao doacao = new Doacao(
                1,
                criarDoador(),
                criarInstituicao(),
                250
        );

        assertNotNull(doacao);
    }

    @Test
    void deveSalvarIdCorretamente() {
        Doacao doacao = new Doacao(
                10,
                criarDoador(),
                criarInstituicao(),
                250
        );

        assertEquals(
                10,
                doacao.getIdDoacao()
        );
    }

    @Test
    void deveSalvarQuantiaCorretamente() {
        Doacao doacao = new Doacao(
                1,
                criarDoador(),
                criarInstituicao(),
                500
        );

        assertEquals(
                500,
                doacao.getQuantiaDoada()
        );
    }

    @Test
    void deveSalvarDoadorCorretamente() {
        Doador doador = criarDoador();

        Doacao doacao = new Doacao(
                1,
                doador,
                criarInstituicao(),
                250
        );

        assertEquals(
                doador,
                doacao.getDoador()
        );
    }

    @Test
    void deveSalvarInstituicaoCorretamente() {
        Instituicao instituicao = criarInstituicao();

        Doacao doacao = new Doacao(
                1,
                criarDoador(),
                instituicao,
                250
        );

        assertEquals(
                instituicao,
                doacao.getInstituicao()
        );
    }

    // =====================================
    // TESTES DE QUANTIA
    // =====================================

    @Test
    void deveAceitarQuantiaValida() {
        Doacao doacao = new Doacao(
                1,
                criarDoador(),
                criarInstituicao(),
                100
        );

        assertEquals(
                100,
                doacao.getQuantiaDoada()
        );
    }

    @Test
    void deveLancarErroParaQuantiaZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doacao(
                        1,
                        criarDoador(),
                        criarInstituicao(),
                        0
                )
        );
    }

    @Test
    void deveLancarErroParaQuantiaNegativa() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doacao(
                        1,
                        criarDoador(),
                        criarInstituicao(),
                        -50
                )
        );
    }

    // =====================================
    // TESTES DE ARRECADAÇÃO
    // =====================================

    @Test
    void deveAdicionarValorNaArrecadacaoDaInstituicao() {
        Instituicao instituicao = criarInstituicao();

        new Doacao(
                1,
                criarDoador(),
                instituicao,
                300
        );

        assertEquals(
                300,
                instituicao.getArrecadacao()
        );
    }

    @Test
    void deveSomarVariasDoacoesNaArrecadacao() {
        Instituicao instituicao = criarInstituicao();

        new Doacao(
                1,
                criarDoador(),
                instituicao,
                100
        );

        new Doacao(
                2,
                criarDoador(),
                instituicao,
                200
        );

        new Doacao(
                3,
                criarDoador(),
                instituicao,
                300
        );

        assertEquals(
                600,
                instituicao.getArrecadacao()
        );
    }

    // =====================================
    // TESTES DE DATA
    // =====================================

    @Test
    void deveGerarDataDoacaoAutomaticamente() {
        Doacao doacao = new Doacao(
                1,
                criarDoador(),
                criarInstituicao(),
                100
        );

        assertNotNull(
                doacao.getDataDoacao()
        );
    }
}