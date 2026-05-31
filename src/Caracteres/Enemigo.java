package Caracteres;

public class Enemigo extends Personaje{
    private int sector;
    private int creditos;
    private int creditosRecompensa;
    private boolean estaVivo;

    public Enemigo(String nombre, int vida, int damage, int sector, int creditosRecompensa) {
        super(nombre, vida, damage);
        this.sector = sector;
        this.creditosRecompensa = creditosRecompensa;
    }

    public int getSector() {
        return sector;
    }

    public int getCreditosRecompensa() {
        return creditosRecompensa;
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }

    @Override
    public String atacar() {
        return getNombre() + " realiza un ataque estandar. Damage: " + getDamage();
    }

    @Override
    public String toString() {
        return getNombre() + " | Vida: " + getVida() + " | Sector: " + sector;
    }
}


