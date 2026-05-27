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
        public int getSector() {
            return sector;
        }
        public int getCreditosRecompensa(){
            return creditosRecompensa;
        }

        //Setters
        public void setSector(int sector) {
            if (sector < 0){
                sector = 0; // el sector nunca puede ser negativo
            }else{
                this.sector = sector;
            }
        }
    }

