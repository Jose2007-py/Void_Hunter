import Caracteres.*;
import Items.Arma;
import Items.Botiquin;
import Items.Item;
import Mercader.Mercader;
import java.util.Random;
import java.util.Scanner;

public class Void_hunter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombrePiloto = "";
        boolean jugarDeNuevo;
        do {
            Random rand = new Random();

            System.out.println("BIENVENIDO AL RPG ESPACIAL — VOID HUNTER");
            System.out.println("Demostración polimorfismo");
            Personaje[] todos = {
                    new EnemigoPirata("Demo Pirata",    60, 15, 1, 25, 5),
                    new EnemigoDrone("Demo Drone",      50, 12, 1, 20, 85),
                    new EnemigoMecanoide("Demo Meca",  100, 30, 2, 40, 3),
                    new EnemigoGuardian("Demo Guard",  110, 25, 2, 45, 40),
                    new EnemigoComandante("Demo Jefe", 200, 50, 3,  0, true)
            };
            for (Personaje p : todos) {
                System.out.println(p.atacar());
            }
            System.out.print("Ingresa tu nombre, piloto: ");
            nombrePiloto = scanner.nextLine().trim();
            if (nombrePiloto.isEmpty()) nombrePiloto = "Piloto";
            System.out.println("Bienvenido, " + nombrePiloto + ". Destruye el arma en la Estacion Oasis.\n");

            Nave miNave = elegirNave(scanner, rand, nombrePiloto);

            Enemigo[] sector1 = enemigosSector1(rand);
            Enemigo[] sector2 = enemigosSector2(rand);
            EnemigoComandante jefe = new EnemigoComandante("COMANDANTE ATLAS",
                    randRango(rand, 180, 220), randRango(rand, 45, 60), 3, 0, true);
            Mercader zyx = crearMercader(rand);
            // Jugar  3 sectores
            System.out.println(" SECTOR 1 — CINTURON DE ASTEROIDES ");
            if (!jugarSector(sector1, miNave, zyx, rand, scanner, true, nombrePiloto)) {
                gameOver("Sector 1", nombrePiloto);
            } else {
                System.out.println(" SECTOR 2 — NEBULOSA CRIMSON ");
                if (!jugarSector(sector2, miNave, zyx, rand, scanner, true, nombrePiloto)) {
                    gameOver("Sector 2", nombrePiloto);
                } else {
                    System.out.println(" SECTOR 3 — ESTACION OASIS ");
                    System.out.println("El Comandante Atlas te espera, " + nombrePiloto + "...\n");
                    if (!jugarSector(new Enemigo[]{jefe}, miNave, zyx, rand, scanner, false, nombrePiloto)) {
                        gameOver("Sector 3", nombrePiloto);
                    } else {
                        System.out.println("VICTORIA! Destruiste el arma. La Federacion te lo agradece, " + nombrePiloto + "!");
                    }
                }
            }
            System.out.print("\n¿Jugar de nuevo? (s/n): ");
            jugarDeNuevo = scanner.next().equalsIgnoreCase("s");
            scanner.nextLine();
        } while (jugarDeNuevo);
    }
    //funcion numero random en rango
    public static int randRango(Random rand, int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
    //funcion para elegir nave
    public static Nave elegirNave(Scanner scanner, Random rand, String nombrePiloto) {
        String[] nombres = {"Fenix", "Sombra", "Centinela", "Kraken", "Espectro",
                "Coloso", "Pulsar", "Requiem", "Valquiria", "Nemesis"};
        Nave[] naves = new Nave[10];
        for (int i = 0; i < 10; i++) {
            naves[i] = new Nave(nombres[i], randRango(rand, 60, 180),
                    randRango(rand, 15, 70), randRango(rand, 0, 60), randRango(rand, 80, 120));
        }
        int a = rand.nextInt(10), b;
        do {
            b = rand.nextInt(10);
        } while (b == a);

        int eleccion;
        do {
            System.out.println("Elige tu nave, " + nombrePiloto + ":");
            System.out.println("[1] " + naves[a]);
            System.out.println("[2] " + naves[b]);
            System.out.print("Opcion: ");
            eleccion = scanner.nextInt();
            if (eleccion != 1 && eleccion != 2)
                System.out.println("Elige 1 o 2.\n");
        } while (eleccion != 1 && eleccion != 2);
        Nave elegida;
        if (eleccion == 1) {
            elegida = naves[a];
        } else {
            elegida = naves[b];
        }        System.out.println("Elegiste: " + elegida.getNombre() + ". A luchar, " + nombrePiloto + "!\n");
        return elegida;
    }
    //Crear enemigos sector 1
    public static Enemigo[] enemigosSector1(Random rand) {
        String[] piratas = {"Pirata Krak", "Pirata Vex", "Pirata Rogue", "Pirata Skar"};
        String[] drones  = {"Drone Scout", "Drone Asesino", "Drone Raptor", "Drone Sombra"};
        Enemigo[] lista = new Enemigo[8];
        for (int i = 0; i < 4; i++)
            lista[i] = new EnemigoPirata(piratas[i], randRango(rand, 40, 80),
                    randRango(rand, 10, 25), 1, randRango(rand, 20, 40), randRango(rand, 3, 8));
        for (int i = 0; i < 4; i++)
            lista[4 + i] = new EnemigoDrone(drones[i], randRango(rand, 40, 80),
                    randRango(rand, 10, 25), 1, randRango(rand, 20, 40), randRango(rand, 70, 99));
        return lista;
    }
    //Crear enemigos sector 2
    public static Enemigo[] enemigosSector2(Random rand) {
        String[] mecanoides = {"Mecanoide X-7", "Mecanoide Z-12", "Mecanoide R-9", "Mecanoide T-4"};
        String[] guardianes = {"Guardian Alpha", "Guardian Omega", "Guardian Sigma", "Guardian Delta"};
        Enemigo[] lista = new Enemigo[8];
        for (int i = 0; i < 4; i++)
            lista[i] = new EnemigoMecanoide(mecanoides[i], randRango(rand, 80, 120),
                    randRango(rand, 25, 40), 2, randRango(rand, 35, 55), randRango(rand, 1, 5));
        for (int i = 0; i < 4; i++)
            lista[4 + i] = new EnemigoGuardian(guardianes[i], randRango(rand, 80, 120),
                    randRango(rand, 25, 40), 2, randRango(rand, 35, 55), randRango(rand, 20, 60));
        return lista;
    }
    //Creacion mercader
    public static Mercader crearMercader(Random rand) {
        String[] nomArmas  = {"Canon de Plasma", "Rifle de Antimateria", "Lanzador de Fotones", "Bomba de Pulso", "Railgun Compacto"};
        String[] descArmas = {"Tecnologia pirata reciclada", "Prototipo militar robado", "Barato pero confiable", "Una sola carga, alto dano", "Lento pero brutal"};
        String[] nomBots   = {"Nanobots", "Parche de Blindaje", "Celula Regeneradora", "Kit de Emergencia", "Reactor Auxiliar"};
        String[] descBots  = {"Se autoinstalan en segundos", "Solucion temporal", "Cara pero vale la pena", "Lo minimo para sobrevivir", "Restaura sistemas criticos"};

        Item[] items = new Item[10];
        for (int i = 0; i < 5; i++)
            items[i] = new Arma(nomArmas[i], descArmas[i], randRango(rand, 25, 80), randRango(rand, 10, 30));
        for (int i = 0; i < 5; i++)
            items[5 + i] = new Botiquin(nomBots[i], descBots[i], randRango(rand, 15, 65), randRango(rand, 15, 50));

        return new Mercader("Zyx, el Mercader Intergalactico", items);
    }
    //funcion para jugar un sector
    public static boolean jugarSector(Enemigo[] lista, Nave nave, Mercader mercader, Random rand, Scanner scanner, boolean hayMercader, String nombrePiloto) {
        for (int encuentro = 0; encuentro < 2; encuentro++) {
            if (encuentro >= lista.length) break;

            int indice = rand.nextInt(lista.length);
            Enemigo enemigo = crearEnemigo(lista[indice].getNombre(), lista[indice].getSector(), rand);
            boolean puedeEscapar = (encuentro == 1);
            boolean escapo = combate(nave, enemigo, rand, scanner, puedeEscapar, nombrePiloto);

            if (!nave.estaViva()) return false;
            if (escapo) {
                System.out.println("Escapaste y sigues tu ruta, " + nombrePiloto + "!\n");
                break;
            }
        }
        if (hayMercader) visitarMercader(mercader, nave, scanner, nombrePiloto);
        return true;
    }
    //funcion crear enemigo
    public static Enemigo crearEnemigo(String nombre, int sector, Random rand) {
        if (sector == 1) {
            if (nombre.contains("Pirata")) {
                return new EnemigoPirata(nombre, randRango(rand, 40, 80),
                        randRango(rand, 10, 25), 1, randRango(rand, 20, 40), randRango(rand, 3, 8));
            } else {
                return new EnemigoDrone(nombre, randRango(rand, 40, 80),
                        randRango(rand, 10, 25), 1, randRango(rand, 20, 40), randRango(rand, 70, 99));
            }
        } else {
            if (nombre.contains("Mecanoide")) {
                return new EnemigoMecanoide(nombre, randRango(rand, 80, 120),
                        randRango(rand, 25, 40), 2, randRango(rand, 35, 55), randRango(rand, 1, 5));
            } else {
                return new EnemigoGuardian(nombre, randRango(rand, 80, 120),
                        randRango(rand, 25, 40), 2, randRango(rand, 35, 55), randRango(rand, 20, 60));
            }
        }
    }
    //funcion combate 
      public static boolean combate(Nave nave, Enemigo enemigo, Random rand, Scanner scanner, boolean puedeEscapar, String nombrePiloto) {
        int costoEscape = randRango(rand, 10, 25);

        System.out.println("Combate: " + nave.getNombre() + " vs " + enemigo.getNombre());
        System.out.println(nave);
        System.out.println(enemigo + "\n");

        boolean turnoJugador = rand.nextBoolean();
            if (turnoJugador) {
                System.out.println("Tu nave ataca primero, " + nombrePiloto + "!\n");
            } else {
                System.out.println(enemigo.getNombre() + " ataca primero!\n");
            }

        boolean turnoSaltado = false;

        while (nave.estaViva() && enemigo.estaVivo()) {
            if (turnoJugador) {
                if (turnoSaltado) {
                    System.out.println("[ Tu nave debe recargar sistemas... turno perdido ]\n");
                    turnoSaltado = false;
                    turnoJugador = false;
                    continue;
                }
                System.out.println("Tu turno, " + nombrePiloto
                        + ". Vida=" + nave.getVida()
                        + "  Damage=" + nave.getDamage()
                        + "  Creditos=" + nave.getCreditos());
                System.out.println("[1] Atacar");
                System.out.println("[2] Ataque cargado (dano x2, pierdes siguiente turno)");
                if (puedeEscapar && nave.getCreditos() >= costoEscape) {
                    System.out.println("[3] Intentar escapar (cuesta " + costoEscape + " creditos, 50% exito)");
                }
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    System.out.println("\n" + nave.atacar());
                    enemigo.setVida(enemigo.getVida() - nave.getDamage());
                    System.out.println(enemigo.getNombre() + " Vida restante: " + enemigo.getVida() + "\n");

                } else if (opcion == 2) {
                    int danoCargado = nave.getDamage() * 2;
                    System.out.println("\n" + nave.getNombre() + " carga todos los sistemas! Dano: " + danoCargado);
                    enemigo.setVida(enemigo.getVida() - danoCargado);
                    System.out.println(enemigo.getNombre() + " Vida restante: " + enemigo.getVida());
                    System.out.println(" Sistemas sobrecalentados — perderas el siguiente turno \n");
                    turnoSaltado = true;

                } else if (opcion == 3 && puedeEscapar && nave.getCreditos() >= costoEscape) {
                    nave.setCreditos(nave.getCreditos() - costoEscape);
                    System.out.println("\nUsas " + costoEscape + " creditos de combustible");
                    if (rand.nextBoolean()) {
                        System.out.println("Escape exitoso, " + nombrePiloto + "! Creditos restantes: " + nave.getCreditos() + "\n");
                        return true;
                    } else {
                        System.out.println("El escape fallo, " + nombrePiloto + "! " + enemigo.getNombre() + " aprovecha y ataca!\n");
                        System.out.println(enemigo.atacar());
                        nave.setVida(nave.getVida() - enemigo.getDamage());
                        System.out.println(nave.getNombre() + " Vida restante: " + nave.getVida() + "\n");
                        if (!nave.estaViva()) return false;
                    }
                } else {
                    System.out.println("\nOpcion no valida, atacas normal");
                    System.out.println(nave.atacar());
                    enemigo.setVida(enemigo.getVida() - nave.getDamage());
                    System.out.println(enemigo.getNombre() + " Vida restante: " + enemigo.getVida() + "\n");
                }

            } else {
                System.out.println(enemigo.atacar());
                nave.setVida(nave.getVida() - enemigo.getDamage());
                System.out.println(nave.getNombre() + " Vida restante: " + nave.getVida() + "\n");
            }
            turnoJugador = !turnoJugador;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " destruido! +"
                    + enemigo.getCreditosRecompensa() + " creditos\n");
            nave.setCreditos(nave.getCreditos() + enemigo.getCreditosRecompensa());
        }
        return false;
    }
    //funcion para visitar al mercader
    public static void visitarMercader(Mercader mercader, Nave nave, Scanner scanner, String nombrePiloto) {
        System.out.println(mercader.getNombre() + " aparece!");
        System.out.println(nombrePiloto + ", tienes " + nave.getCreditos() + " creditos.");
        Item[] oferta = mercader.ofrecerItems();
        System.out.println("Tengo esto para ti:\n");
        for (int i = 0; i < oferta.length; i++) {
            System.out.println("  [" + (i + 1) + "] " + oferta[i]);
        }
        System.out.println("  [0] No comprar nada");
        System.out.print("\nOpcion: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= 3) {
            Item elegido = oferta[opcion - 1];
            if (nave.getCreditos() >= elegido.getPrecio()) {
                nave.setCreditos(nave.getCreditos() - elegido.getPrecio());
                nave.usarItem(elegido);
                System.out.println("Creditos restantes: " + nave.getCreditos() + "\n");
            } else {
                System.out.println("No tienes suficientes creditos, " + nombrePiloto + "!\n");
            }
        } else {
            System.out.println("Seguiste tu camino sin comprar nada.\n");
        }
    }
    public static void gameOver(String sector, String nombrePiloto) {
        System.out.println("GAME OVER, " + nombrePiloto + ".");
        System.out.println("Tu nave fue destruida en " + sector + ".");
    }
}