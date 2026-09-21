package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.EstadoJogo;
import models.Cena;
import models.Protagonista;
import models.Capitulo;


class EstadoJogoTest {

    private EstadoJogo estadoJogo;
    private Capitulo capitulo1;
    private Cena cena1;
    private Cena cena2;

    @BeforeEach
    void setUp() {
        Protagonista kat = new Protagonista(1, "Kat", "EQUILIBRADO");
        estadoJogo = new EstadoJogo(kat);

        capitulo1 = new Capitulo(1, "O Início");
        cena1 = new Cena(101, "Acordando", "Você acorda.", "Narrativa");
        cena2 = new Cena(102, "Corredor", "Um corredor escuro.", "Exploração");

        capitulo1.adicionarCena(cena1);
        capitulo1.adicionarCena(cena2);
        estadoJogo.adicionarCapitulo(capitulo1);
    }

    @Test
    void testeIniciarJogo() {
        estadoJogo.iniciarJogo();

        // O jogo deve iniciar no primeiro capítulo e na sua primeira cena[cite: 3]
        assertEquals(capitulo1, estadoJogo.getCapituloAtual());
        assertEquals(cena1, estadoJogo.getCenaAtual());
        assertFalse(estadoJogo.isJogoEncerrado());
        assertNull(estadoJogo.getFinalAlcancado());
    }

    @Test
    void testeIrParaCenaExistente() {
        estadoJogo.iniciarJogo();
        boolean encontrou = estadoJogo.irParaCena(102);

        // A transição procura a cena em todos os capítulos e atualiza os ponteiros[cite: 3]
        assertTrue(encontrou);
        assertEquals(cena2, estadoJogo.getCenaAtual());
    }

    @Test
    void testeIrParaCenaInexistente() {
        estadoJogo.iniciarJogo();
        boolean encontrou = estadoJogo.irParaCena(999);

        assertFalse(encontrou);
        assertEquals(cena1, estadoJogo.getCenaAtual(), "A cena atual não deve mudar se a busca falhar");
    }
}