// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes.model.contacts;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TelefoneInstituicaoTest {

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
    void deveCriarTelefoneInstituicaoValido() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
        );

        assertNotNull(telefone);
    }

    @Test
    void deveSalvarTelefoneCorretamente() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
        );

        assertEquals(
                "88999999999",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveSalvarInstituicaoCorretamente() {
        Instituicao instituicao = criarInstituicao();

        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                instituicao
        );

        assertEquals(
                instituicao,
                telefone.getInstituicao()
        );
    }

    // =====================================
    // TESTES DE TELEFONE
    // =====================================

    @Test
    void deveAceitarTelefoneCom10Digitos() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "8833334444",
                criarInstituicao()
        );

        assertEquals(
                "8833334444",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveAceitarTelefoneCom11Digitos() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
        );

        assertEquals(
                "88999999999",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveAlterarTelefoneCorretamente() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
        );

        telefone.setNumTelefone("88988887777");

        assertEquals(
                "88988887777",
                telefone.getNumTelefone()
        );
    }

    @Test
    void deveLancarErroParaTelefoneNulo() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
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
                () -> new TelefoneInstituicao(
                        1,
                        "123",
                        criarInstituicao()
                )
        );
    }

    @Test
    void deveLancarErroParaTelefoneComMaisDe11Digitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneInstituicao(
                        1,
                        "123456789012345",
                        criarInstituicao()
                )
        );
    }

    @Test
    void deveLancarErroParaTelefoneComLetras() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneInstituicao(
                        1,
                        "88999abc999",
                        criarInstituicao()
                )
        );
    }

    // =====================================
    // TESTES DE INSTITUIÇÃO
    // =====================================

    @Test
    void deveAlterarInstituicaoCorretamente() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
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

        telefone.setInstituicao(novaInstituicao);

        assertEquals(
                novaInstituicao,
                telefone.getInstituicao()
        );
    }

    @Test
    void deveLancarErroParaInstituicaoNula() {
        TelefoneInstituicao telefone = new TelefoneInstituicao(
                1,
                "88999999999",
                criarInstituicao()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> telefone.setInstituicao(null)
        );
    }

    // =====================================
    // TESTES DE CONSTRUTOR INVÁLIDO
    // =====================================

    @Test
    void deveLancarErroNoConstrutorParaInstituicaoNula() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TelefoneInstituicao(
                        1,
                        "88999999999",
                        null
                )
        );
    }
}