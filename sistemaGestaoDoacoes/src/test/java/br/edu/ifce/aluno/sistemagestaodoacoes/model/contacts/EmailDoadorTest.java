// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class EmailDoadorTest {

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
    // TESTES DO CONSTRUTOR
    // =====================================

    @Test
    void deveCriarEmailDoadorValido() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        assertNotNull(email);
    }

    @Test
    void deveSalvarEmailCorretamente() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        assertEquals(
                "contato@gmail.com",
                email.getEmail()
        );
    }

    @Test
    void deveSalvarDoadorCorretamente() {
        Doador doador = criarDoador();

        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                doador
        );

        assertEquals(
                doador,
                email.getDoador()
        );
    }

    // =====================================
    // TESTES DE EMAIL
    // =====================================

    @Test
    void deveAlterarEmailCorretamente() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        email.setEmail("novo@gmail.com");

        assertEquals(
                "novo@gmail.com",
                email.getEmail()
        );
    }

    @Test
    void deveLancarErroParaEmailInvalido() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setEmail("emailinvalido")
        );
    }

    @Test
    void deveLancarErroParaEmailNulo() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setEmail(null)
        );
    }

    // =====================================
    // TESTES DE DOADOR
    // =====================================

    @Test
    void deveAlterarDoadorCorretamente() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        Doador novoDoador = new Doador(
                2,
                "Maria Silva",
                "Senha@654321",
                "maria@gmail.com",
                LocalDateTime.now(),
                "98765432100"
        );

        email.setDoador(novoDoador);

        assertEquals(
                novoDoador,
                email.getDoador()
        );
    }

    @Test
    void deveLancarErroParaDoadorNulo() {
        EmailDoador email = new EmailDoador(
                1,
                "contato@gmail.com",
                criarDoador()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setDoador(null)
        );
    }

    // =====================================
    // TESTES DE CONSTRUTOR INVÁLIDO
    // =====================================

    @Test
    void deveLancarErroNoConstrutorParaEmailInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailDoador(
                        1,
                        "emailinvalido",
                        criarDoador()
                )
        );
    }

    @Test
    void deveLancarErroNoConstrutorParaDoadorNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailDoador(
                        1,
                        "contato@gmail.com",
                        null
                )
        );
    }
}