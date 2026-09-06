
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int option;
        option = openMenu();
        while(!List.of(1,2,3).contains(option))
           option = openMenu();

    }


    public static int openMenu(){
        limpaTerminal();
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("digite o número da opção desejada");
        System.out.println("------Menu principal-------");
        System.out.println("Opção 1 - Jogar");
        System.out.println("Opção 2 - Créditos");
        System.out.println("Opção 3 - sair");
        
        try{

        return scanner.nextInt();
        }
        catch(Exception e){
            System.out.println("entrada inválida");
            return 0;
        }

    }

    public static void limpaTerminal(){
        try {
            String SO = System.getProperty("os.name");

            if (SO.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

        } catch (Exception e) {
            System.out.println("terminal não limpo, excessão: " + e);
        }
    }

}