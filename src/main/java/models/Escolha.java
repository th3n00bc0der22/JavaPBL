
package models;

import java.util.ArrayList;
import java.util.List;

public class Escolha {

    private int id;
    private String textoOpcao;
    private int proximaCenaId;


    // =========================================================
    // CONSEQUÊNCIAS
    // =========================================================

    private int deltaMemoria;
    private int deltaEstabilidade;
    private int deltaCulpa;

    private int deltaConfiancaFauan;
    private int deltaVinculoPassos;
    private int deltaSuspeitaToin;

    private Pista pistaGanha;


    // =========================================================
    // CONDIÇÕES DE DESBLOQUEIO
    // =========================================================

    private String personagemNecessario;

    private int valorMinimoNecessario;

    /*
     * Algumas escolhas exigem determinado temperamento.
     *
     * Valores utilizados:
     *
     * "SANGUE_FRIO"
     * "EQUILIBRADO"
     * "SANGUE_QUENTE"
     */
    private String temperamentoNecessario;


    /*
     * Uma escolha pode exigir MAIS DE UMA pista.
     *
     * Exemplo:
     *
     * "Pergunta sobre o alarme"
     * +
     * "Alarme desligado manualmente"
     */
    private List<String> pistasNecessarias;


    /*
     * Algumas escolhas do Capítulo 5 dependem
     * da postura definida no Capítulo 4.
     *
     * "NEGACAO_TOTAL"
     * ou
     * "DUVIDA_ABERTA"
     */
    private String posturaNecessaria;


    // =========================================================
    // OUTRAS CARACTERÍSTICAS DA ESCOLHA
    // =========================================================

    /*
     * Tom da resposta:
     *
     * "SANGUE_FRIO"
     * "EQUILIBRADO"
     * "SANGUE_QUENTE"
     */
    private String tom;


    /*
     * Algumas escolhas alteram a postura
     * da protagonista sobre a paternidade.
     */
    private String posturaResultante;


    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public Escolha(
            int id,
            String textoOpcao,
            int proximaCenaId) {

        this.id = id;
        this.textoOpcao = textoOpcao;
        this.proximaCenaId = proximaCenaId;

        /*
         * Toda escolha começa sem exigir pistas.
         */
        this.pistasNecessarias = new ArrayList<>();
    }


    // =========================================================
    // GETTERS
    // =========================================================

    public int getId() {
        return id;
    }


    public String getTextoOpcao() {
        return textoOpcao;
    }


    public int getProximaCenaId() {
        return proximaCenaId;
    }


    // =========================================================
    // DEFINIÇÃO DOS EFEITOS
    // =========================================================

    public void definirEfeitos(
            int deltaMemoria,
            int deltaEstabilidade,
            int deltaCulpa,
            int deltaConfiancaFauan,
            int deltaVinculoPassos,
            int deltaSuspeitaToin) {

        this.deltaMemoria =
                deltaMemoria;

        this.deltaEstabilidade =
                deltaEstabilidade;

        this.deltaCulpa =
                deltaCulpa;

        this.deltaConfiancaFauan =
                deltaConfiancaFauan;

        this.deltaVinculoPassos =
                deltaVinculoPassos;

        this.deltaSuspeitaToin =
                deltaSuspeitaToin;
    }


    public void definirPistaGanha(
            Pista pista) {

        this.pistaGanha = pista;
    }


    // =========================================================
    // CONDIÇÕES
    // =========================================================

    /*
     * Define:
     *
     * - personagem relacionado à condição;
     * - valor mínimo necessário;
     * - temperamento necessário.
     *
     * Exemplos:
     *
     * definirCondicao(
     *     "Toin",
     *     40,
     *     "SANGUE_FRIO"
     * );
     *
     * definirCondicao(
     *     "Passos",
     *     65,
     *     null
     * );
     */
    public void definirCondicao(
            String personagemNecessario,
            int valorMinimoNecessario,
            String temperamentoNecessario) {

        this.personagemNecessario =
                personagemNecessario;

        this.valorMinimoNecessario =
                valorMinimoNecessario;

        this.temperamentoNecessario =
                temperamentoNecessario;
    }


    /*
     * Uma escolha pode exigir várias pistas.
     *
     * Basta chamar este método várias vezes.
     */
    public void adicionarPistaNecessaria(
            String nomePista) {

        pistasNecessarias.add(
                nomePista
        );
    }


    /*
     * Define a postura que precisa existir
     * para que a escolha apareça.
     */
    public void definirPosturaNecessaria(
            String postura) {

        this.posturaNecessaria =
                postura;
    }


    // =========================================================
    // TOM
    // =========================================================

    public void definirTom(
            String tom) {

        this.tom = tom;
    }


    // =========================================================
    // POSTURA RESULTANTE
    // =========================================================

    /*
     * Define qual postura será assumida
     * DEPOIS que essa escolha for selecionada.
     */
    public void definirPosturaResultante(
            String postura) {

        this.posturaResultante =
                postura;
    }


    // =========================================================
    // VERIFICA SE A ESCOLHA ESTÁ DISPONÍVEL
    // =========================================================

    public boolean estaDisponivel(
            Protagonista protagonista) {


        // -----------------------------------------------------
        // RELACIONAMENTO
        // -----------------------------------------------------

        if (personagemNecessario != null) {

            int valorAtual = 0;


            if (personagemNecessario.equals("Fauan")) {

                valorAtual =
                        protagonista.getConfiancaFauan();

            } else if (
                    personagemNecessario.equals("Passos")) {

                valorAtual =
                        protagonista.getVinculoPassos();

            } else if (
                    personagemNecessario.equals("Toin")) {

                valorAtual =
                        protagonista.getSuspeitaToin();
            }


            if (valorAtual
                    < valorMinimoNecessario) {

                return false;
            }
        }


        // -----------------------------------------------------
        // TEMPERAMENTO
        // -----------------------------------------------------

        if (temperamentoNecessario != null
                && !temperamentoNecessario.equals(
                protagonista.getTemperamento()
        )) {

            return false;
        }


        // -----------------------------------------------------
        // PISTAS
        // -----------------------------------------------------

        /*
         * TODAS as pistas adicionadas precisam existir.
         */
        for (String pista : pistasNecessarias) {

            if (!protagonista.possuiPista(
                    pista
            )) {

                return false;
            }
        }


        // -----------------------------------------------------
        // POSTURA
        // -----------------------------------------------------

        if (posturaNecessaria != null
                && !posturaNecessaria.equals(
                protagonista.getPosturaPaternidade()
        )) {

            return false;
        }


        return true;
    }


    // =========================================================
    // APLICA AS CONSEQUÊNCIAS
    // =========================================================

    public void aplicarConsequencias(
            Protagonista protagonista) {


        // -----------------------------------------------------
        // DELTAS
        // -----------------------------------------------------

        protagonista.ajustarMemoria(
                deltaMemoria
        );

        protagonista.ajustarEstabilidade(
                deltaEstabilidade
        );

        protagonista.ajustarCulpa(
                deltaCulpa
        );

        protagonista.ajustarConfiancaFauan(
                deltaConfiancaFauan
        );

        protagonista.ajustarVinculoPassos(
                deltaVinculoPassos
        );

        protagonista.ajustarSuspeitaToin(
                deltaSuspeitaToin
        );


        // -----------------------------------------------------
        // PISTA GANHA
        // -----------------------------------------------------

        if (pistaGanha != null) {

            protagonista.adicionarPista(
                    pistaGanha
            );
        }


        // -----------------------------------------------------
        // POSTURA DE PATERNIDADE
        // -----------------------------------------------------

        if (posturaResultante != null) {

            protagonista.setPosturaPaternidade(
                    posturaResultante
            );
        }


        // -----------------------------------------------------
        // MECÂNICA DE TOM
        // -----------------------------------------------------

        /*
         * Capítulo 2, 4 e 5:
         *
         * Tom == Temperamento
         *      +5 Estabilidade
         *
         * Tom != Temperamento
         *      -5 Estabilidade
         *      +5 Confiança em Fauan
         */
        if (tom != null) {

            if (tom.equals(
                    protagonista.getTemperamento()
            )) {

                protagonista.ajustarEstabilidade(
                        5
                );

            } else {

                protagonista.ajustarEstabilidade(
                        -5
                );

                protagonista.ajustarConfiancaFauan(
                        5
                );
            }
        }
    }
}
