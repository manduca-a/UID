package lab;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Magazzino M = new Magazzino();

        int x=1;
        while (x>0){
            System.out.println("\t1 - Aggiungi un Prodotto \n\t2 - Rimuovi un Prodotto\n\t3 - Cerca un Prodotto\n\t4 - Ordina Prodotti\n\t5 - Stampa tutti i Prodotti\n\n\t0 - Esci\n");

            Scanner scelta = new Scanner(System.in);
            x = scelta.nextInt();

            switch (x){
                case 1:
                    Scanner prod = new Scanner(System.in);
                    System.out.print("Inserisci l'ID -> ");
                    String id = prod.nextLine();
                    System.out.print("Inserisci il tipo -> ");
                    String tipo = prod.nextLine();
                    System.out.print("Inserisci la marca -> ");
                    String marca = prod.nextLine();
                    System.out.print("Inserisci il modello -> ");
                    String modello = prod.nextLine();
                    System.out.print("Inserisci l'anno di produzione -> ");
                    int anno = prod.nextInt();
                    System.out.print("Inserisci il prezzo -> ");
                    double prezzo = prod.nextDouble();

                    Prodotto p = new Prodotto(id, tipo, marca, modello, anno, prezzo);

                    if (M.aggiungiP(p)){
                        System.out.println("\n\tInserito!\n");
                    }
                    else{
                        System.out.println("\n\tGià dentro!\n");
                    }
                    break;

                case 2:
                    prod = new Scanner(System.in);
                    System.out.print("Inserisci l'ID -> ");
                    id = prod.nextLine();

                    if (M.rimuoviP(id)){
                        System.out.println("\n\tRimosso!\n");
                    }
                    else{
                        System.out.println("\n\tInesistente!\n");
                    }
                    break;

                case 3:
                    System.out.println("\t1 - Cerca per Marca\n\t2 - Cerca per Modello\n\t3 - Cerca per Anno");
                    int s = scelta.nextInt();

                    switch (s){
                        case 1:
                            System.out.print("Inserisci la marca -> ");
                            String marca = ;
                    }
            }
        }
    }

}
