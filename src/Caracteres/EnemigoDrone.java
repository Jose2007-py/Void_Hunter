package Caracteres;

public class EnemigoDrone {
  private int velocidad;

  public EnemigoDrone(String nombre, int vida, int damage, int sector, int creditos, int velocidad) {
        super(nombre, vida, damage, sector, creditos); 
        this.velocidad = velocidad;
    }
    public int getVelocidad() {
        return velocidad;
}
 @Override
    public String atacar() {
        return getNombre() + " ejecuta un ataque relampago a velocidad " + velocidad + "! Damage: " + getDamage();
    }
