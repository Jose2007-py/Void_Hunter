package Caracteres;

import Items.Item;

import java.util.Random;

public class Mercader {
    // Atributos
    private String nombre;
    private Item[] inventario; //  Total de items del mercader

    // Constructor
    public Mercader(String nombre, Item[] inventario) {
        this.nombre = nombre;
        this.inventario = inventario;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Devuelve 3 items random distintos del inventario
    public Item[] ofrecerItems() {
        Random rand = new Random();
        Item[] oferta = new Item[3];
        int[] indices = new int[3];

        int encontrados = 0;
        while (encontrados < 3) {
            int indice = rand.nextInt(inventario.length);
            // verificar que no se repita
            boolean repetido = false;
            for (int i = 0; i < encontrados; i++) {
                if (indices[i] == indice) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                indices[encontrados] = indice;
                oferta[encontrados] = inventario[indice];
                encontrados++;
            }
        }
        return oferta;
    }

    // Muestra el dialogo del mercader con su oferta
    public void mostrarTienda(Nave nave) {
        System.out.println("  " + nombre + " aparece en tu camino!");
        System.out.println("  Creditos disponibles: " + nave.getCreditos());

        Item[] oferta = ofrecerItems();
        System.out.println("Tengo esto para ti, piloto:\n");
        for (int i = 0; i < oferta.length; i++) {
            System.out.println("  [" + (i + 1) + "] " + oferta[i]);
        }
        System.out.println("  [0] No comprar nada");
    }
}

