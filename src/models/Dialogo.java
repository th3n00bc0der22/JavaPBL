package models;

public class Dialogo {

    private Personagem personagem;
    private String conteudo;
    private String tipo;

    public Dialogo(Personagem personagem, String conteudo, String tipo) {
        this.personagem = personagem;
        this.conteudo = conteudo;
        this.tipo = tipo;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getTipo() {
        return tipo;
    }
}