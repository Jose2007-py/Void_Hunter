package Items;

import Caracteres.Nave;

public class Arma extends  Item{
    private int bonusDamage;
    public Arma(String nombre, String descripcion, int precio,int bonusDamage ){
        super(nombre, descripcion, precio);
        this.bonusDamage=bonusDamage;

    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    @Override
    public String usar(Nave nave) {
        nave.setDamage(nave.getDamage() + bonusDamage);
        return "Equipaste " + getNombre() + ". Damage aumentado en +" + bonusDamage + "!";
    }
}
