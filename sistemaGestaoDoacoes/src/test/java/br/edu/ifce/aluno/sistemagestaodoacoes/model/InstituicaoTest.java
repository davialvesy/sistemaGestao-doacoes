// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
public class InstituicaoTest {

    // =====================================
    // MÉTODO AUXILIAR
    // =====================================

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
    // TESTES DE CNPJ
    // =====================================

    @Test
    void deveAceitarCnpjValido() {

        assertTrue(
                Instituicao.validacaoCnpj("12345678000199")
        );
    }

    @Test
    void deveAceitarCnpjComMascara() {

        assertTrue(
                Instituicao.validacaoCnpj("12.345.678/0001-99")
        );
    }

    @Test
    void deveRecusarCnpjNulo() {

        assertFalse(
                Instituicao.validacaoCnpj(null)
        );
    }

    @Test
    void deveRecusarCnpjVazio() {

        assertFalse(
                Instituicao.validacaoCnpj(" ")
        );
    }

    @Test
    void deveRecusarCnpjMenorQue14Digitos() {

        assertFalse(
                Instituicao.validacaoCnpj("123")
        );
    }

    @Test
    void deveRecusarCnpjMaiorQue14Digitos() {

        assertFalse(
                Instituicao.validacaoCnpj("123456789012345678")
        );
    }

    // =====================================
    // TESTES DE ARRECADAÇÃO
    // =====================================

    @Test
    void deveAceitarArrecadacaoValida() {

        Instituicao instituicao = criarInstituicao();

        instituicao.setArrecadacao(500);

        assertEquals(
                500,
                instituicao.getArrecadacao()
        );
    }

    @Test
    void deveLancarErroParaArrecadacaoNegativa() {

        Instituicao instituicao = criarInstituicao();

        assertThrows(
                IllegalArgumentException.class,
                () -> instituicao.setArrecadacao(-10)
        );
    }

    // =====================================
    // TESTES DE DOAÇÃO
    // =====================================

    @Test
    void deveAdicionarDoacaoCorretamente() {

        Instituicao instituicao = criarInstituicao();

        instituicao.adicionarDoacao(250);

        assertEquals(
                250,
                instituicao.getArrecadacao()
        );
    }

    @Test
    void deveSomarMultiplasDoacoes() {

        Instituicao instituicao = criarInstituicao();

        instituicao.adicionarDoacao(100);
        instituicao.adicionarDoacao(200);
        instituicao.adicionarDoacao(300);

        assertEquals(
                600,
                instituicao.getArrecadacao()
        );
    }

    @Test
    void deveLancarErroParaDoacaoNegativa() {

        Instituicao instituicao = criarInstituicao();

        assertThrows(
                IllegalArgumentException.class,
                () -> instituicao.adicionarDoacao(-50)
        );
    }

    @Test
    void deveLancarErroParaDoacaoZero() {

        Instituicao instituicao = criarInstituicao();

        assertThrows(
                IllegalArgumentException.class,
                () -> instituicao.adicionarDoacao(0)
        );
    }

    // =====================================
    // TESTES DO CONSTRUTOR
    // =====================================

    @Test
    void deveCriarInstituicaoValida() {

        Instituicao instituicao = criarInstituicao();

        assertNotNull(instituicao);
    }

    @Test
    void deveLancarErroParaCnpjInvalidoNoConstrutor() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Instituicao(
                        1,
                        "Instituto Esperanca",
                        "Senha@123456",
                        "instituto@gmail.com",
                        LocalDateTime.now(),
                        0,
                        "123"
                )
        );
    }

    @Test
    void deveLancarErroParaArrecadacaoNegativaNoConstrutor() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Instituicao(
                        1,
                        "Instituto Esperanca",
                        "Senha@123456",
                        "instituto@gmail.com",
                        LocalDateTime.now(),
                        -100,
                        "12345678000199"
                )
        );
    }
}