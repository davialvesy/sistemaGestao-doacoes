// Created by Davi

package br.edu.ifce.aluno.sistemagestaodoacoes;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doacao;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Doador;
import br.edu.ifce.aluno.sistemagestaodoacoes.model.Instituicao;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void deveCadastrarDoador() {

        Doador doador = new Doador(
                1,
                "João",
                "Davi.davi123456",
                "joao@gmail.com",
                LocalDateTime.now(),
                "12345678901"
        );

        assertEquals("João", doador.getNome());
        assertEquals("12345678901", doador.getCpf());
    }

    @Test
    void deveCadastrarInstituicao() {

        Instituicao instituicao = new Instituicao(
                1,
                "Lar Esperança",
                "123",
                "lar@gmail.com",
                LocalDateTime.now(),
                0,
                "11222333000199"
        );

        assertEquals("Lar Esperança", instituicao.getNome());
    }

    @Test
    void deveRealizarDoacao() {

        Doador doador = new Doador(
                1,
                "Maria",
                "123",
                "maria@gmail.com",
                LocalDateTime.now(),
                "99999999999"
        );

        Instituicao instituicao = new Instituicao(
                1,
                "Casa do Bem",
                "456",
                "casa@gmail.com",
                LocalDateTime.now(),
                0,
                "99888777000155"
        );

        Doacao doacao = new Doacao(
                1,
                doador,
                instituicao,
                250.0
        );

        assertEquals(250.0, doacao.getQuantiaDoada());
        assertEquals("Maria", doacao.getDoador().getNome());
        assertEquals("Casa do Bem", doacao.getInstituicao().getNome());
    }

    @Test
    void deveAdicionarEmArrayLists() {

        ArrayList<Doador> doadores = new ArrayList<>();

        Doador doador = new Doador(
                1,
                "Carlos",
                "123",
                "carlos@gmail.com",
                LocalDateTime.now(),
                "11111111111"
        );

        doadores.add(doador);

        assertFalse(doadores.isEmpty());
        assertEquals(1, doadores.size());
    }

}