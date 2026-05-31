package Caracteres;

import Items.Item;

public class Nave extends Personaje{
    private int escudo;
    private int creditos;
    public Nave(String nombre, int vida, int damage, int escudo, int creditos){
        super(nombre, vida, damage);
        this.escudo=escudo;
        this.creditos=creditos;

    }
    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public void usarItem(Item item){
        System.out.println(item.usar(this));
    }
    public boolean estaViva(){
        return getVida()>0;
    }

    @Override
    public String atacar() {
        return getNombre()+" dispara laser de energia! Daño: "+getDamage();
     }
    @Override
    public String toString() {
        return getNombre() + "  Vida: " + getVida() + "  Damage: " + getDamage()
                + "  Escudo: " + escudo + "  Creditos: " + creditos;
    }
}
