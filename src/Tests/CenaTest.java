package Tests;

import models.Cena;
import models.Escolha;
import models.Protagonista;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import models.Dialogo;



class CenaTest {

    @Test
    void testeGetEscolhasDisponiveisFiltraCorretamente() {
        Protagonista protagonista = new Protagonista(1, "Kat", "EQUILIBRADO");
        Cena cena = new Cena(1, "Sala", "Você vê duas portas.", "Interativa");

        Escolha escolhaLivre = new Escolha(1, "Entrar na esquerda", 2);

        Escolha escolhaBloqueada = new Escolha(2, "Entrar na direita", 3);
        escolhaBloqueada.definirCondicao(null, 0, "SANGUE_FRIO"); // Protagonista não tem esse temperamento

        cena.adicionarEscolha(escolhaLivre);
        cena.adicionarEscolha(escolhaBloqueada);

        List<Escolha> disponiveis = cena.getEscolhasDisponiveis(protagonista);

        // Deve retornar apenas a escolha que passa na validação do método estaDisponivel[cite: 3]
        assertEquals(1, disponiveis.size());
        assertEquals(1, disponiveis.get(0).getId());
    }

    @Test
    void testeProximaCenaPadrao() {
        Cena cena = new Cena(1, "Sala", "Você vê duas portas.", "Interativa");
        // -1 significa que não existe próxima cena automática inicialmente[cite: 3]
        assertEquals(-1, cena.getProximaCenaId());

        cena.definirProximaCena(5);
        assertEquals(5, cena.getProximaCenaId());
    }
}