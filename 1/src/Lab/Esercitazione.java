package Lab;
import java.io.*;
import java.util.Scanner;

public class Esercitazione {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        //1
        int[] arr = new int[10];
        for(int i=0; i<arr.length;i++) {
            int a=i+1;
            System.out.println("Digita il "+ a + "° elemento: ");
            arr[i] = input.nextInt();
        }

        //2
        for (int i:arr){
            System.out.print(i + " ");
        }
        System.out.println();

        //3
        int max=0;
        for(int i:arr) {
            if(i>max) {
                max=i;
            }
        }
        System.out.println("massimo" + max);

        //4
        int min=max;
        for(int i:arr) {
            if(i<min) {
                min=i;
            }
        }
        System.out.println("minimo" +min);

        //5
        int somma=0;
        for(int i:arr) {
            somma+=i;
        }
        double media = somma/arr.length;
        System.out.println("media" + media);



    }
}
