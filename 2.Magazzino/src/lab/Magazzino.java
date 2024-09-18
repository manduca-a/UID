package lab;

import java.util.ArrayList;
import java.util.Objects;

public class Magazzino{

    public Magazzino(){};

   private ArrayList<Prodotto> lista = new ArrayList<Prodotto>();

    public boolean aggiungiP(Prodotto p) {
        int i;
        for (i = 0; i < lista.size(); i++) {
            if (Objects.equals(lista.get(i).getId(), p.getId())) {
                return false;
            }
        }
        lista.add(p);
        return true;
    }

    public boolean rimuoviP(String id) {
        for (int i = 0; i < lista.size(); i++) {
            if (Objects.equals(lista.get(i).getId(), id)) {
                lista.remove(lista.get(i));
                return true;
            }
        }
        return false;
    }

    public ArrayList<Prodotto> permarca(String marca) {
        ArrayList<Prodotto> marche = new ArrayList<Prodotto>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getMarca() == marca) {
                marche.add(lista.get(i));
            }
        }
        return(marche);
    }
    public ArrayList<Prodotto> permodello(String modello) {
        ArrayList<Prodotto> modelli = new ArrayList<Prodotto>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getModello() == modello) {
                modelli.add(lista.get(i));
            }
        }
        return(modelli);
    }
    public ArrayList<Prodotto> peranno(int anno) {
        ArrayList<Prodotto> anni = new ArrayList<Prodotto>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAnno_prod() == anno) {
                anni.add(lista.get(i));
            }
        }
        return(anni);
    }

    public void stampaP() {
        for (int i = 0; i < lista.size(); i++) {
           System.out.println(lista.get(i));
        }
    }

}
