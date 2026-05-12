// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class DoadorTest {

    // =====================================
    // MÉTODO AUXILIAR
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

    // =====================================
    // TESTES DE CPF
    // =====================================

    @Test
    void deveAceitarCpfValido() {
        Doador doador = criarDoador();

        assertEquals(
                "12345678901",
                doador.getCpf()
        );
    }

    @Test
    void deveLancarErroParaCpfNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doador(
                        1,
                        "Carlos Silva",
                        "Senha@123456",
                        "carlos@gmail.com",
                        LocalDateTime.now(),
                        null
                )
        );
    }

    @Test
    void deveLancarErroParaCpfComMenosDe11Digitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doador(
                        1,
                        "Carlos Silva",
                        "Senha@123456",
                        "carlos@gmail.com",
                        LocalDateTime.now(),
                        "123"
                )
        );
    }

    @Test
    void deveLancarErroParaCpfComMaisDe11Digitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doador(
                        1,
                        "Carlos Silva",
                        "Senha@123456",
                        "carlos@gmail.com",
                        LocalDateTime.now(),
                        "123456789012345"
                )
        );
    }

    @Test
    void deveLancarErroParaCpfComLetras() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doador(
                        1,
                        "Carlos Silva",
                        "Senha@123456",
                        "carlos@gmail.com",
                        LocalDateTime.now(),
                        "12345abc901"
                )
        );
    }

    // =====================================
    // TESTES DE SETCPF
    // =====================================

    @Test
    void deveAlterarCpfCorretamente() {
        Doador doador = criarDoador();

        doador.setCpf("98765432100");

        assertEquals(
                "98765432100",
                doador.getCpf()
        );
    }

    @Test
    void deveLancarErroAoAlterarCpfInvalido() {
        Doador doador = criarDoador();

        assertThrows(
                IllegalArgumentException.class,
                () -> doador.setCpf("123")
        );
    }

    // =====================================
    // TESTES DO CONSTRUTOR
    // =====================================

    @Test
    void deveCriarDoadorValido() {
        Doador doador = criarDoador();

        assertNotNull(doador);
    }

    @Test
    void deveCriarDoadorComNomeCorreto() {
        Doador doador = criarDoador();

        assertEquals(
                "Carlos Silva",
                doador.getNome()
        );
    }

    @Test
    void deveAutenticarSenhaCorreta() {
        Doador doador = criarDoador();

        assertTrue(
                doador.autenticar("Senha@123456")
        );
    }

    @Test
    void deveRecusarSenhaIncorreta() {
        Doador doador = criarDoador();

        assertFalse(
                doador.autenticar("123")
        );
    }
}