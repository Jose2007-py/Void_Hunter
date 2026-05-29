import Caracteres.Nave;

import java.util.Scanner;
import java.util.Random;
public class Void_hunter{
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Random rand=new Random();

       System.out.println("  RPG ESPACIAL — VOID  ");
       System.out.println("La Federacion Galactica te necesita, piloto.");
       System.out.println("Cruza los 3 sectores y destruye el arma en");
       System.out.println("la Estacion Oasis. Buena suerte.\n");

       String[] nombresNaves={ "Fenix", "Sombra", "Centinela", "Kraken", "Espectro",
               "Coloso", "Pulsar", "Requiem", "Valquiria", "Nemesis"};

       Nave[] todasLasNaves = new Nave[10];
        for(int i=0; i<10; i++){
            int vida= randRango(rand, 80,120);
            int damage=randRango(rand, 15, 70);
            int escudo   = randRango(rand,  0,   60);
            int creditos = randRango(rand, 80,  120);
            todasLasNaves[i]= new Nave(nombresNaves[i],vida, damage, escudo, creditos);

       }
       int indice1 = rand.nextInt(10);
       int indice2;
       do {
           indice2 = rand.nextInt(10);
       } while (indice2 == indice1);
       System.out.println("Elige tu nave:\n");
       System.out.println("[1] " + todasLasNaves[indice1]);
       System.out.println("[2] " + todasLasNaves[indice1]);
       System.out.print("\nOpcion: ");

   }
    public static int randRango(Random rand, int min, int max) {

       return rand.nextInt(max - min + 1) + min;
    }


}
