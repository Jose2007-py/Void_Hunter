import Caracteres.*;
import Items.Arma;
import Items.Botiquin;
import Items.Item;
import Mercader.Mercader;

import java.util.Random;
import java.util.Scanner;

public class Void_hunter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nombrePiloto = "";
        boolean jugarDeNuevo;

        do {
            Random rand = new Random();

            System.out.println("BIENVENIDO AL RPG ESPACIAL — VOID HUNTER");
            System.out.print("Ingresa tu nombre, piloto: ");
            nombrePiloto = scanner.nextLine().trim();
            if (nombrePiloto.isEmpty()) nombrePiloto = "Piloto";
            System.out.println("Bienvenido, " + nombrePiloto + ". Destruye el arma en la Estacion Oasis.\n");

            Nave miNave = elegirNave(scanner, rand, nombrePiloto);





        } while ();



    }
    public static int randRango(Random rand, int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
    public static Nave elegirNave(Scanner scanner, Random rand, String nombrePiloto) {
        String[] nombres = {"Fenix", "Sombra", "Centinela", "Kraken", "Espectro",
                "Coloso", "Pulsar", "Requiem", "Valquiria", "Nemesis"};
        Nave[] naves = new Nave[10];
        for (int i = 0; i < 10; i++) {
            naves[i] = new Nave(nombres[i], randRango(rand, 60, 180),
                    randRango(rand, 15, 70), randRango(rand, 0, 60), randRango(rand, 80, 120));
        }

        int a = rand.nextInt(10), b;
        do {
            b = rand.nextInt(10);
        } while (b == a);

        int eleccion;
        do {
            System.out.println("Elige tu nave, " + nombrePiloto + ":");
            System.out.println("[1] " + naves[a]);
            System.out.println("[2] " + naves[b]);
            System.out.print("Opcion: ");
            eleccion = scanner.nextInt();
            if (eleccion != 1 && eleccion != 2)
                System.out.println("Elige 1 o 2.\n");
        } while (eleccion != 1 && eleccion != 2);

        Nave elegida = (eleccion == 1) ? naves[a] : naves[b];
        System.out.println("Elegiste: " + elegida.getNombre() + ". A luchar, " + nombrePiloto + "!\n");
        return elegida;
    }
}