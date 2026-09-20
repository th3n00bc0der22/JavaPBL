package controllers;

import views.MenuView;

import java.util.List;

public class MenuController {

    public static Boolean menuPrincipalController() {

        int option = 0;


        while (option != 4) {

            option = MenuView.openMenu();


            while (!List.of(
                    1, 2, 3, 4
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

                int atributoOption =
                        MenuView.openAtributesMenu();


                /*
                 * Primeiro valida.
                 */
                while (!List.of(
                        1, 2, 3
                ).contains(atributoOption)) {

                    MenuView.apresentaErro(
                            "A entrada fornecida é inválida."
                    );

                    atributoOption =
                            MenuView.openAtributesMenu();
                }


                /*
                 * Só depois inicia o jogo.
                 */
                JogoController jogoController =
                        new JogoController();

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

                return true;
            }
        }


        return false;
    }
}
