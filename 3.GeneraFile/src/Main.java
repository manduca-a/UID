import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String nome = "prova.txt";
        try {
            Ese1.generaFile(nome);
            System.out.println("\n\tLineeNumeriche");
            Ese1.stampaLineeNumeriche(nome);
            System.out.println("\n\tLineeConNumero");
            Ese1.stampaLineeConNumero(nome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
