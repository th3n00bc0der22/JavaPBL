package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.Pista;
class PistaTest {

    @Test
    void testeCriacaoPista() {
        Pista pista = new Pista("Bilhete", "Um bilhete rasgado");

        assertEquals("Bilhete", pista.getNome());
        assertEquals("Um bilhete rasgado", pista.getDescricao());
    }
}