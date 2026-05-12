// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TelefoneDoadorTest {

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
    void deveCriarTelefoneDoadorValido() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        assertNotNull(telefone);
    }

    @Test
    void deveSalvarTelefoneCorretamente() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        assertEquals(
                "88999999999",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveSalvarDoadorCorretamente() {
        Doador doador = criarDoador();

        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                doador
        );

        assertEquals(
                doador,
                telefone.getDoador()
        );
    }

    // =====================================
    // TESTES DE TELEFONE
    // =====================================

    @Test
    void deveAceitarTelefoneCom10Digitos() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "8833334444",
                criarDoador()
        );

        assertEquals(
                "8833334444",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveAceitarTelefoneCom11Digitos() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        assertEquals(
                "88999999999",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveAlterarTelefoneCorretamente() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        telefone.setNumTelefone("88988887777");

        assertEquals(
                "88988887777",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveLancarErroParaTelefoneNulo() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> telefone.setNumTelefone(null)
        );
    }

    @Test
    void deveLancarErroParaTelefoneComMenosDe10Digitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneDoador(
                        1,
                        "123",
                        criarDoador()
                )
        );
    }

    @Test
    void deveLancarErroParaTelefoneComMaisDe11Digitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneDoador(
                        1,
                        "123456789012345",
                        criarDoador()
                )
        );
    }

    @Test
    void deveLancarErroParaTelefoneComLetras() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneDoador(
                        1,
                        "88999abc999",
                        criarDoador()
                )
        );
    }

    // =====================================
    // TESTES DE DOADOR
    // =====================================

    @Test
    void deveAlterarDoadorCorretamente() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
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

        telefone.setDoador(novoDoador);

        assertEquals(
                novoDoador,
                telefone.getDoador()
        );
    }

    @Test
    void deveLancarErroParaDoadorNulo() {
        TelefoneDoador telefone = new TelefoneDoador(
                1,
                "88999999999",
                criarDoador()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> telefone.setDoador(null)
        );
    }

    // =====================================
    // TESTES DE CONSTRUTOR INVÁLIDO
    // =====================================

    @Test
    void deveLancarErroNoConstrutorParaTelefoneInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneDoador(
                        1,
                        "123",
                        criarDoador()
                )
        );
    }
}