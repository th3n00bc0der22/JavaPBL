package Tests;

import models.Prelacionavel;
import models.Psecundario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonagensSecundariosTest {

    @Test
    void testePsecundarioHeranca() {
        Psecundario npc = new Psecundario(2, "Fauan");

        assertEquals(2, npc.getId());
        assertEquals("Fauan", npc.getNome());

        npc.setNome("Fauan Silva");
        assertEquals("Fauan Silva", npc.getNome());
    }

    @Test
    void testePrelacionavelPercepcao() {
        Prelacionavel npcRelacionavel = new Prelacionavel(3, "Toin");
        npcRelacionavel.setPercepcao("Amigável");

        assertEquals("Amigável", npcRelacionavel.getPercepcao());
    }
}