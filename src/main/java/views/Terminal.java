package views;

public class Terminal {


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

    public static void aplicaDelay(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
