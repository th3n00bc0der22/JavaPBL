package models;


public class Prelacionavel extends Personagem {
    private String percepcao;

    public Prelacionavel(int id, String nome) {
        super(id, nome);
    }

    public String getPercepcao() { return percepcao; }
    public void setPercepcao(String percepcao) { this.percepcao = percepcao; }


}