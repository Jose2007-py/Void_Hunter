package Caracteres;

public class Enemigos extends Personaje{
    private int sector;
    private int creditos;
    private int creditosRecompensa;
    private boolean estaVivo;

    public Enemigos(String nombre, int vida, int damage, int sector, int creditosRecompensa) {
        super(nombre, vida, damage);
        this.sector = sector;
        this.creditosRecompensa = creditosRecompensa;
    }

    //Setters
    public int getSector() {
        return sector;
    }

    public int getCreditosRecompensa() {
        return creditosRecompensa;
    }

    // Verifica si el enemigo sigue vivo
    public boolean estaVivo() {
        return getVida() > 0;
    }

    // Metodo base — las subclases lo sobreescriben
    @Override
    public String atacar() {
        return getNombre() + " realiza un ataque estandar. Damage: " + getDamage();
    }

    @Override
    public String toString() {
        return getNombre() + " | Vida: " + getVida() + " | Sector: " + sector;
    }
}


