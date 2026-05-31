package Caracteres;

public class Personaje {
    private String nombre;
    private int vida;
    protected int damage;
    //Constructor
    public Personaje(String nombre, int vida, int damage) {
        this.nombre = nombre;
        this.setVida(vida);
        this.setDamage(damage);
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getDamage(){
        return damage;
    }
    public int getVida() {
        return vida;
    }

    //Setters
    public void setVida(int vida) {
        if (vida < 0){
            this.vida = 0; // la vida nunca puede ser negativa
        }else{
            this.vida = vida;

        }
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String atacar() {
        return nombre + " realiza un ataque basico.";
    }
    @Override
    public String toString(){
        return nombre + " | Vida: " + vida + " | Damage: " + damage;
    }

}
