package Items;

import Caracteres.Nave;

public class Arma extends Item {

    // Atributo propio de Arma
    private int bonusDamage;

    // Constructor — llama al padre con super()
    public Arma(String nombre, String descripcion, int precio, int bonusDamage) {
        super(nombre, descripcion,precio); // inicializa atributos del padre
        this.bonusDamage = bonusDamage;
    }

    // Getter
    public int getBonusDamage() {
        return bonusDamage;
    }

    // Polimorfismo — redefine usar() del padre
    @Override
    public String usar(Nave nave) {
        nave.setDamage(nave.getDamage() + bonusDamage);
        return "Equipaste " + getNombre() + ". Damage aumentado en +" + bonusDamage + "!";
    }
    @Override
    public String toString() {
        return getNombre() + " | " + getDescripcion()
                + " | +"+bonusDamage+" damage | Precio: " + getPrecio() + " creditos";
    }
}
