package Tests;

import models.Inventario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {

    @Test
    void testeCriacaoEFlagsDoInventario() {
        Inventario inventario = new Inventario(10);
        assertEquals(10, inventario.getId());

        assertFalse(inventario.isAcessivel(), "O inventário deve inicializar falso para booleanos não definidos");

        inventario.setAcessivel(true);
        assertTrue(inventario.isAcessivel());
    }
}