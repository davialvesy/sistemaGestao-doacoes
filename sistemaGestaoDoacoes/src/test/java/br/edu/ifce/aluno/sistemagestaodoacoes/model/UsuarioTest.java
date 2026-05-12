// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    // Classe fake apenas para testes
    static class UsuarioFake extends Usuario {

        public UsuarioFake(int id, String nome, String senha,
                           String email, LocalDateTime dataCadastro) {

            super(id, nome, senha, email, dataCadastro);
        }
    }

    // =========================
    // TESTES DE NOME
    // =========================

    @Test
    void deveAceitarNomeValido() {

        assertTrue(
                Usuario.validacaoNome("Carlos Silva")
        );
    }

    @Test
    void deveRecusarNomeNulo() {

        assertFalse(
                Usuario.validacaoNome(null)
        );
    }

    @Test
    void deveRecusarNomeVazio() {

        assertFalse(
                Usuario.validacaoNome(" ")
        );
    }

    @Test
    void deveRecusarNomeComNumeros() {

        assertFalse(
                Usuario.validacaoNome("Carlos123")
        );
    }

    @Test
    void deveRecusarNomeComSimbolos() {

        assertFalse(
                Usuario.validacaoNome("Carlos@")
        );
    }

    // =========================
    // TESTES DE EMAIL
    // =========================

    @Test
    void deveAceitarEmailValido() {

        assertTrue(
                Usuario.validacaoEmail("carlos@gmail.com")
        );
    }

    @Test
    void deveRecusarEmailSemArroba() {

        assertFalse(
                Usuario.validacaoEmail("carlosgmail.com")
        );
    }

    @Test
    void deveRecusarEmailNulo() {

        assertFalse(
                Usuario.validacaoEmail(null)
        );
    }

    @Test
    void deveRecusarEmailVazio() {

        assertFalse(
                Usuario.validacaoEmail(" ")
        );
    }

    // =========================
    // TESTES DE SENHA
    // =========================

    @Test
    void deveAceitarSenhaValida() {

        assertTrue(
                Usuario.validacaoSenha("Senha@123456")
        );
    }

    @Test
    void deveRecusarSenhaCurta() {

        assertFalse(
                Usuario.validacaoSenha("Aa@1")
        );
    }

    @Test
    void deveRecusarSenhaSemNumero() {

        assertFalse(
                Usuario.validacaoSenha("Senha@Senha")
        );
    }

    @Test
    void deveRecusarSenhaSemMaiuscula() {

        assertFalse(
                Usuario.validacaoSenha("senha@123456")
        );
    }

    @Test
    void deveRecusarSenhaSemMinuscula() {

        assertFalse(
                Usuario.validacaoSenha("SENHA@123456")
        );
    }

    @Test
    void deveRecusarSenhaSemEspecial() {

        assertFalse(
                Usuario.validacaoSenha("Senha123456")
        );
    }

    // =========================
    // TESTES DE AUTENTICAÇÃO
    // =========================

    @Test
    void deveAutenticarSenhaCorreta() {

        UsuarioFake usuario = new UsuarioFake(
                1,
                "Carlos Silva",
                "Senha@123456",
                "carlos@gmail.com",
                LocalDateTime.now()
        );

        assertTrue(
                usuario.autenticar("Senha@123456")
        );
    }

    @Test
    void deveRecusarSenhaIncorreta() {

        UsuarioFake usuario = new UsuarioFake(
                1,
                "Carlos Silva",
                "Senha@123456",
                "carlos@gmail.com",
                LocalDateTime.now()
        );

        assertFalse(
                usuario.autenticar("123")
        );
    }

    // =========================
    // TESTES DE EXCEÇÕES
    // =========================

    @Test
    void deveLancarErroParaNomeInvalido() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioFake(
                        1,
                        "123",
                        "Senha@123456",
                        "email@gmail.com",
                        LocalDateTime.now()
                )
        );
    }

    @Test
    void deveLancarErroParaEmailInvalido() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioFake(
                        1,
                        "Carlos",
                        "Senha@123456",
                        "emailinvalido",
                        LocalDateTime.now()
                )
        );
    }

    @Test
    void deveLancarErroParaSenhaInvalida() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioFake(
                        1,
                        "Carlos",
                        "123",
                        "email@gmail.com",
                        LocalDateTime.now()
                )
        );
    }
}