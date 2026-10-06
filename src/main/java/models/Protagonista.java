package models;


import java.util.ArrayList;
import java.util.List;

public class Protagonista extends Personagem {
    private String temperamento;

    // Os 3 atributos de Kat, com score de 0 a 100 como foi visto nas ST's
    private int memoria;
    private int estabilidadeEmocional;
    private int culpaPercebida;

    // Os 3 relacionamentos com Kat, com score de 0 a 100 como foi visto nas ST's
    private int confiancaFauan;
    private int vinculoPassos;
    private int suspeitaToin;

    // "INDEFINIDA", "NEGACAO_TOTAL" ou "DUVIDA_ABERTA".
    private String posturaPaternidade;

    // Todas as pistas colecionadas com Kat ficam armazenadas em uma lista
    private List<Pista> pistas;

    public Protagonista(int id, String nome, String temperamento) {
        super(id, nome);
        this.temperamento = temperamento;
        this.memoria = 0;
        this.estabilidadeEmocional = 50;
        this.culpaPercebida = 50;
        this.confiancaFauan = 50;
        this.vinculoPassos = 50;
        this.suspeitaToin = 50;
        this.posturaPaternidade = "INDEFINIDA";
        this.pistas = new ArrayList<>();
    }

    private int limitar(int valor) {
        if (valor < 0) {
            return 0;
        }
        if (valor > 100) {
            return 100;
        }
        return valor;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public int getMemoria() {
        return memoria;
    }

    public void ajustarMemoria(int delta) {
        memoria = limitar(memoria + delta);
    }

    public int getEstabilidadeEmocional() {
        return estabilidadeEmocional;
    }

    public void ajustarEstabilidade(int delta) {
        estabilidadeEmocional = limitar(estabilidadeEmocional + delta);
    }

    public int getCulpaPercebida() {
        return culpaPercebida;
    }

    public void ajustarCulpa(int delta) {
        culpaPercebida = limitar(culpaPercebida + delta);
    }

    public int getConfiancaFauan() {
        return confiancaFauan;
    }

    public void ajustarConfiancaFauan(int delta) {
        confiancaFauan = limitar(confiancaFauan + delta);
    }

    public int getVinculoPassos() {
        return vinculoPassos;
    }

    public void ajustarVinculoPassos(int delta) {
        vinculoPassos = limitar(vinculoPassos + delta);
    }

    public int getSuspeitaToin() {
        return suspeitaToin;
    }

    public void ajustarSuspeitaToin(int delta) {
        suspeitaToin = limitar(suspeitaToin + delta);
    }

    public String getPosturaPaternidade() {
        return posturaPaternidade;
    }

    public void setPosturaPaternidade(String posturaPaternidade) {
        this.posturaPaternidade = posturaPaternidade;
    }

    public List<Pista> getPistas() {
        return pistas;
    }

    //Adiciona uma pista à lista, mas primeiro verifica se ela já existe.
    public void adicionarPista(Pista pista) {
        if (!possuiPista(pista.getNome())) {
            pistas.add(pista);
        }
    }

    // Verifica se já existe uma pista com determinado nome dentro da lista pistas
    public boolean possuiPista(String nomePista) {
        for (Pista pista : pistas) {
            if (pista.getNome().equals(nomePista)) {
                return true;
            }
        }
        return false;
    }
}
