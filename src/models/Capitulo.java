package models;

//import Cena.java;

import java.util.ArrayList;
import java.util.List;

public class Capitulo {

    private int id;
    private String titulo;
    private List<Cena> cenas;

    public Capitulo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.cenas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Cena> getCenas() {
        return cenas;
    }

    public void adicionarCena(Cena cena) {
        cenas.add(cena);
    }

    // Busca simples em lista (for comum), sem Map.
    public Cena getCena(int id) {
        for (Cena cena : cenas) {
            if (cena.getId() == id) {
                return cena;
            }
        }
        return null;
    }

    public Cena getCenaInicial() {
        return cenas.get(0);
    }
}


