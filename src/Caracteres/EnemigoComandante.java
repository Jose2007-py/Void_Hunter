package Caracteres;

public class EnemigoComandante extends Enemigo {
    
   private boolean llamadaRefuerzo;


    public EnemigoComandante(String nombre, int vida, int damage, int sector, int creditos, boolean llamadaRefuerzo) {
        super(nombre, vida, damage, sector, creditos); // inicializa atributos de Enemigo
        this.llamadaRefuerzo = llamadaRefuerzo;
    }

    public boolean getLlamadaRefuerzo() {
        return llamadaRefuerzo;
    }

    @Override
    public String atacar() {
        if (getVida() < 50 && llamadaRefuerzo) {
            return getNombre() + " activa ULTIMA ORDEN! Ataque devastador! Damage: " + (getDamage() * 2);
        }
        return getNombre() + " dispara canones de plasma! Damage: " + getDamage();
    }
}


