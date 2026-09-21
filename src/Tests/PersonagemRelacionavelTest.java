package Tests;
import models.Prelacionavel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonagemRelacionavelTest {

    @Test
    void testePercepcaoEHeranca() {
        Prelacionavel npcRelacionavel = new Prelacionavel(3, "Toin");

        // Testa o setter e getter específicos desta classe
        npcRelacionavel.setPercepcao("Amigável");
        assertEquals("Amigável", npcRelacionavel.getPercepcao());

        // Garante que a herança do ID e Nome continuam intactas
        assertEquals(3, npcRelacionavel.getId());
        assertEquals("Toin", npcRelacionavel.getNome());
    }
}