package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    /*
     * Um único Scanner para toda a classe.
     */
    private static final Scanner scanner =
            new Scanner(System.in);


    // ==============================
    // MENU PRINCIPAL
    // ==============================

    public static int openMenu() {

        Terminal.limpaTerminal();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "           A NOITE QUE NÃO SE APAGA"
        );

        System.out.println(
                "========================================"
        );

        System.out.println();

        System.out.println(
                "1 - Nova partida"
        );

        System.out.println(
                "2 - Instruções"
        );

        System.out.println(
                "3 - Créditos"
        );

        System.out.println(
                "4 - Sair"
        );

        System.out.print(
                "\nDigite o número da opção desejada: "
        );


        try {

            int opcao = scanner.nextInt();

            /*
             * IMPORTANTE:
             * remove o ENTER deixado pelo nextInt().
             */
            scanner.nextLine();

            return opcao;

        } catch (InputMismatchException e) {

            scanner.nextLine();

            return -1;
        }
    }


    // ==============================
    // ESCOLHA DO TEMPERAMENTO
    // ==============================

    public static int openAtributesMenu() {

        Terminal.limpaTerminal();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "        TEMPERAMENTO DE KATARINA"
        );

        System.out.println(
                "========================================"
        );

        System.out.println();

        System.out.println(
                "Escolha como Katarina costuma reagir"
        );

        System.out.println(
                "diante de situações de pressão."
        );

        System.out.println();

        System.out.println(
                "1 - Sangue frio"
        );

        System.out.println(
                "2 - Equilíbrio"
        );

        System.out.println(
                "3 - Sangue quente"
        );

        System.out.print(
                "\nDigite o número da opção desejada: "
        );


        try {

            int opcao = scanner.nextInt();

            scanner.nextLine();

            return opcao;

        } catch (InputMismatchException e) {

            scanner.nextLine();

            return -1;
        }
    }


    // ==============================
    // INSTRUÇÕES
    // ==============================

    public static void Instrucoes() {

        Terminal.limpaTerminal();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "              INSTRUÇÕES"
        );

        System.out.println(
                "========================================"
        );

        System.out.println();


        System.out.println(
                "Você acompanha Katarina, uma mulher"
        );

        System.out.println(
                "que tenta reconstruir os acontecimentos"
        );

        System.out.println(
                "de uma noite marcada por um incêndio"
        );

        System.out.println(
                "em sua própria casa."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Durante um interrogatório conduzido pelo"
        );

        System.out.println(
                "detetive Fauan, lembranças do passado"
        );

        System.out.println(
                "começam a se misturar ao presente."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Suas escolhas determinam como Katarina"
        );

        System.out.println(
                "responde, interpreta suas memórias e"
        );

        System.out.println(
                "se relaciona com as pessoas envolvidas."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Ao longo da investigação, suas decisões"
        );

        System.out.println(
                "podem alterar:"
        );


        System.out.println();

        System.out.println(
                "- a memória de Katarina;"
        );

        System.out.println(
                "- sua estabilidade emocional;"
        );

        System.out.println(
                "- sua percepção de culpa;"
        );

        System.out.println(
                "- sua relação com outros personagens;"
        );

        System.out.println(
                "- as pistas encontradas durante a história."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Algumas respostas e caminhos só estarão"
        );

        System.out.println(
                "disponíveis caso determinadas condições"
        );

        System.out.println(
                "tenham sido alcançadas anteriormente."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Por isso, cada decisão pode provocar"
        );

        System.out.println(
                "consequências imediatas ou aparecer"
        );

        System.out.println(
                "novamente muito tempo depois."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Quando uma escolha aparecer, digite o"
        );

        System.out.println(
                "número correspondente à opção desejada."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "Não existe um único caminho."
        );

        System.out.println(
                "As decisões tomadas durante a investigação"
        );

        System.out.println(
                "podem levar a diferentes conclusões."
        );

        Terminal.aplicaDelay(2500);

        System.out.println();

        System.out.println(
                "[Pressione ENTER para voltar ao menu]"
        );

        scanner.nextLine();
    }


    // ==============================
    // CRÉDITOS
    // ==============================

    public static void Creditos() {

        Terminal.limpaTerminal();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "               CRÉDITOS"
        );

        System.out.println(
                "========================================"
        );

        System.out.println();

        System.out.println(
                "Desenvolvido por:"
        );

        Terminal.aplicaDelay(600);

        System.out.println();

        System.out.println(
                "Bruno Carneiro"
        );
        Terminal.aplicaDelay(600);

        System.out.println(
                "Raphael Henrique"
        );
        Terminal.aplicaDelay(600);

        System.out.println();

        System.out.println(
                "Obrigado por jogar!"
        );

        System.out.println();

        System.out.println(
                "[Pressione ENTER para voltar ao menu]"
        );

        scanner.nextLine();
    }


    // ==============================
    // ERRO
    // ==============================

    public static void apresentaErro(
            String mensagem) {

        System.out.println();

        System.out.println(mensagem);

        Terminal.aplicaDelay(900);
    }
}