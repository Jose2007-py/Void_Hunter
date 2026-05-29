package Caracteres;

public class EnemigoMecanoide extends Enemigos {
    
    private int nivelEMP;
    
    public EnemigoMecanoide(String nombre, int vida, int damage, int sector, int creditos, int nivelEMP) {
        super(nombre, vida, damage, sector, creditos);
        this.nivelEMP = nivelEMP;
    }

    public int getNivelEMP() {
        return nivelEMP;
    }
      @Override
    public String atacar() {
        return getNombre() + " activa pulso EMP nivel " + nivelEMP + "! Damage: " + getDamage();
    }
}
