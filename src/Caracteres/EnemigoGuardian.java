package Caracteres;

public class EnemigoGuardian extends Enemigo {
    
     private int escudoEnergetico;

    // Constructor — llama al padre con super()
    public EnemigoGuardian(String nombre, int vida, int damage, int sector, int creditos, int escudoEnergetico) {
        super(nombre, vida, damage, sector, creditos); // inicializa atributos de Enemigo
        this.escudoEnergetico = escudoEnergetico;
    }


    public int getEscudoEnergetico() {
        return escudoEnergetico;
    }
     @Override
    public String atacar() {
        return getNombre() + " activa escudo energetico nivel " + escudoEnergetico + " y contraataca! Damage: " + getDamage();
    }
    }

