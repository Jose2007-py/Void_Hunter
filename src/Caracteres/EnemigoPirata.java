package Caracteres;

public class EnemigoPirata extends Enemigo {
    
    private int cantMisiles;

    public EnemigoPirata(String nombre, int vida, int damage, int sector, int creditosRecompensa, int cantMisiles) {
        super(nombre, vida, damage, sector, creditosRecompensa);
        this.cantMisiles = cantMisiles;

    }
    public int getCantMisiles() {
        return cantMisiles;
    }
    @Override
    public String atacar() {
        return getNombre() + " lanza una rafaga de " + cantMisiles + " misiles!  Damage: " + getDamage();
    }

}
