package Items;

import Caracteres.Nave;

public class Item {
    private String nombre;
    private String descripcion;
    private int precio;

    public Item(String nombre, String descripcion, int precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;

    }
    public String getNombre(){
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }
    public String usar(Nave nave) {

        return "Usaste " + nombre + ".";
    }
    @Override
    public String toString() {
        return nombre + "  " + descripcion + "  Precio: " + precio + " creditos";
    }

}
