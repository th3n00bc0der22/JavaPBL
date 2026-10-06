package controllers;

import models.Protagonista;
import views.MenuView;

import java.awt.*;
import java.util.List;

public class MenuController {

    public static Boolean menuPrincipalController() {
        int option = 0;

        while (option != 4) {
            option = MenuView.openMenu();

            while (!List.of(
                    1, 2, 3, 4, 5
            ).contains(option)) {

                MenuView.apresentaErro(
                        "A entrada fornecida é inválida."
                );

                option =
                        MenuView.openMenu();
            }

            /*
             * NOVA PARTIDA
             */
            if (option == 1) {
                int atributoOption = MenuView.openAtributesMenu();

                /*
                 * Primeiro valida.
                 */
                while (!List.of(1, 2, 3).contains(atributoOption)) {

                    MenuView.apresentaErro(
                            "A entrada fornecida é inválida."
                    );

                    atributoOption = MenuView.openAtributesMenu();
                }


                /*
                 * Só depois inicia o jogo.
                 */
                JogoController jogoController = new JogoController();

                jogoController.iniciarJogo(
                        atributoOption
                );
            }

            /*
             * INSTRUÇÕES
             */
            if (option == 2) {
                MenuView.Instrucoes();
            }

            /*
             * CRÉDITOS
             */
            if (option == 3) {
                MenuView.Creditos();
            }

            /*
             * SAIR
             */
            if (option == 4) {
                int optionDados = MenuView.salvarDados();

                if (optionDados == 1){
                  MenuView.salvandoDados();
                    Protagonista kat = new Protagonista(1, "Kat", "Sangue Frio");

                    // A memória começa em 0, vai para 20
                    kat.ajustarMemoria(20);
                    // A estabilidade começa em 50, cai para 40
                    kat.ajustarEstabilidade(-10);

                    Database save = new Database("save_kat.json");
                    save.salvarProgresso(kat);

                    Protagonista katCarregada = save.carregarProgresso();
                }

                else if(optionDados == -1) {
                    MenuView.apresentaErro("Entrada inválida");
                }

            }
            if (option == 5) {
                return true;
            }
        }
        return false;
    }
}