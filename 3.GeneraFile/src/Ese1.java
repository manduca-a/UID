import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ese1 {
    static void generaFile(String nomeFile) throws IOException {
        Random r = new Random();
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String numeri = "0123456789";
        String perRandom = upper + lower + numeri;

        int dimensioneFile = r.nextInt(5, 30);
        String pa = "C:/Users/utente/Desktop/";
        String path = pa+nomeFile;
        File file = null;
        try {
            file = new File(path);
            if (file.exists())
                System.out.println("Il file " + path + " esiste");
            else if (file.createNewFile()) {
                System.out.println("Il file " + path + " è stato creato");
                BufferedWriter fw = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < dimensioneFile; i++) {
                    int lunghezzaRandom = r.nextInt(1, 10);
                    StringBuilder sb = new StringBuilder(lunghezzaRandom);
                    for (int j = 0; j < lunghezzaRandom; j++) {
                        int randomInt = r.nextInt(perRandom.length());
                        char randomChar = perRandom.charAt(randomInt);
                        sb.append(randomChar);
                    }
                    fw.write(sb.toString());
                    fw.newLine();
                }
                fw.close();
            }
            else
                System.out.println("Il file " + path + " non può essere creato");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> leggiFile(String nomeFile){
        BufferedReader in = null;
        List<String> lette = new ArrayList<String>();

        try {
            in = new BufferedReader(new FileReader(nomeFile));
            while(in.ready()) {
                lette.add(in.readLine());
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lette;
    }

    static void stampaLineeNumeriche(String nomeFile){
        List<String> leggo = leggiFile(nomeFile);

        for (int i = 0; i < leggo.size(); i++) {
            String s = leggo.get(i);
            if (isNum(s)){
                System.out.println(s);
            }
        }

    }

    private static boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    static void stampaLineeConNumero(String nomeFile){
        List<String> leggo = leggiFile(nomeFile);

        for (int i = 0; i < leggo.size(); i++) {
            String s = leggo.get(i);
            if (contNum(s)){
                System.out.println(s);
            }
        }
    }

    private static boolean contNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '0' && c < '9') {
                return true;
            }
        }
        return false;
    }

    void stampaLineeConLetterePari(String nomeFile, char lettera){

    }

    void stampaLineeConNumeroUguale(String nomeFile, char lettera1, char lettera2){

    }
}
