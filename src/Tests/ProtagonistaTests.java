package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.Protagonista;
import models.Pista;
class ProtagonistaTest {

    private Protagonista protagonista;

    @BeforeEach
    void setUp() {
        // Inicializa um novo protagonista antes de cada teste para garantir isolamento
        protagonista = new Protagonista(1, "Kat", "Melancólica");
    }

    @Test
    void testeInicializacaoValoresPadrao() {
        assertEquals("Melancólica", protagonista.getTemperamento());
        assertEquals(0, protagonista.getMemoria());
        assertEquals(50, protagonista.getEstabilidadeEmocional());
        assertEquals("INDEFINIDA", protagonista.getPosturaPaternidade());
        assertTrue(protagonista.getPistas().isEmpty());
    }

    @Test
    void testeAjustarMemoriaDentroDoLimite() {
        protagonista.ajustarMemoria(20);
        assertEquals(20, protagonista.getMemoria());
    }

    @Test
    void testeLimiteSuperiorCento() {
        // O valor inicial da estabilidade é 50. Somar 60 daria 110.
        protagonista.ajustarEstabilidade(60);
        assertEquals(100, protagonista.getEstabilidadeEmocional(), "O valor não deve ultrapassar 100");
    }

    @Test
    void testeLimiteInferiorZero() {
        // O valor inicial de suspeitaToin é 50. Subtrair 60 daria -10.
        protagonista.ajustarSuspeitaToin(-60);
        assertEquals(0, protagonista.getSuspeitaToin(), "O valor não deve ser menor que 0");
    }

    @Test
    void testeAdicionarPistaNova() {
        Pista pista = new Pista("Faca", "Encontrada na cozinha");
        protagonista.adicionarPista(pista);

        assertEquals(1, protagonista.getPistas().size());
        assertTrue(protagonista.possuiPista("Faca"));
    }

    @Test
    void testeNaoAdicionarPistaDuplicada() {
        Pista pista1 = new Pista("Faca", "Encontrada na cozinha");
        Pista pista2 = new Pista("Faca", "Mesma pista, objeto diferente em memória");

        protagonista.adicionarPista(pista1);
        protagonista.adicionarPista(pista2); // Não deve ser adicionada pois o nome é igual

        assertEquals(1, protagonista.getPistas().size(), "Pistas com o mesmo nome não devem ser duplicadas");
    }
}