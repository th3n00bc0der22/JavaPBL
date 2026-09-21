package Tests;


import models.Capitulo;
import models.Cena;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CapituloTest {

    @Test
    void testeBuscaDeCenasNoCapitulo() {
        Capitulo cap = new Capitulo(1, "Capítulo 1");
        Cena cena1 = new Cena(10, "Início", "...", "Narrativa");
        Cena cena2 = new Cena(20, "Meio", "...", "Ação");

        cap.adicionarCena(cena1);
        cap.adicionarCena(cena2);

        assertEquals(cena1, cap.getCenaInicial(), "Deve retornar o índice 0 da lista[cite: 3]");
        assertEquals(cena2, cap.getCena(20), "A busca por ID deve encontrar a cena correta[cite: 3]");
        assertNull(cap.getCena(99), "Deve retornar null para ID inexistente[cite: 3]");
    }
}