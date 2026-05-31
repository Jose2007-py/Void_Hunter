
package Items;

import Caracteres.Nave;

public class Botiquin extends Item {

    // Atributo propio de Botiquin
    private int vidaRestaurada;

    public Botiquin(String nombre, String descripcion, int precio, int vidaRestaurada) {
        super(nombre, descripcion, precio); // inicializa atributos del padre
        this.vidaRestaurada = vidaRestaurada;
    }


    public int getVidaRestaurada() {
        return vidaRestaurada;
    }


    @Override
    public String usar(Nave nave) {
        nave.setVida(nave.getVida() + vidaRestaurada);
        return "Usaste " + getNombre() + ". Vida restaurada en +" + vidaRestaurada + "!";
    }
    @Override
    public String toString() {
        return getNombre() + "  " + getDescripcion()
                + "  +"+vidaRestaurada+" vida  Precio: " + getPrecio() + " creditos";
    }
}
