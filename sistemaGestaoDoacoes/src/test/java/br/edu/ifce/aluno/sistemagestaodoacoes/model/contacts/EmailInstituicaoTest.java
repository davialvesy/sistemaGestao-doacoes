// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class EmailInstituicaoTest {

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
    // TESTES DO CONSTRUTOR
    // =====================================

    @Test
    void deveCriarEmailInstituicaoValido() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        assertNotNull(email);
    }

    @Test
    void deveSalvarEmailCorretamente() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        assertEquals(
                "contato@instituto.com",
                email.getEmail()
        );
    }

    @Test
    void deveSalvarInstituicaoCorretamente() {
        Instituicao instituicao = criarInstituicao();

        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                instituicao
        );

        assertEquals(
                instituicao,
                email.getInstituicao()
        );
    }

    // =====================================
    // TESTES DE EMAIL
    // =====================================

    @Test
    void deveAlterarEmailCorretamente() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        email.setEmail("novo@instituto.com");

        assertEquals(
                "novo@instituto.com",
                email.getEmail()
        );
    }

    @Test
    void deveLancarErroParaEmailInvalido() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setEmail("emailinvalido")
        );
    }

    @Test
    void deveLancarErroParaEmailNulo() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setEmail(null)
        );
    }

    // =====================================
    // TESTES DE INSTITUIÇÃO
    // =====================================

    @Test
    void deveAlterarInstituicaoCorretamente() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        Instituicao novaInstituicao = new Instituicao(
                2,
                "Instituto Novo",
                "Senha@654321",
                "novo@gmail.com",
                LocalDateTime.now(),
                0,
                "98765432000100"
        );

        email.setInstituicao(novaInstituicao);

        assertEquals(
                novaInstituicao,
                email.getInstituicao()
        );
    }

    @Test
    void deveLancarErroParaInstituicaoNula() {
        EmailInstituicao email = new EmailInstituicao(
                1,
                "contato@instituto.com",
                criarInstituicao()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> email.setInstituicao(null)
        );
    }

    // =====================================
    // TESTES DE CONSTRUTOR INVÁLIDO
    // =====================================

    @Test
    void deveLancarErroNoConstrutorParaEmailInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailInstituicao(
                        1,
                        "emailinvalido",
                        criarInstituicao()
                )
        );
    }

    @Test
    void deveLancarErroNoConstrutorParaInstituicaoNula() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailInstituicao(
                        1,
                        "contato@instituto.com",
                        null
                )
        );
    }
}