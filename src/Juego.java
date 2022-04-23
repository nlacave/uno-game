import java.util.Scanner;

public class Juego {
    public Juego () {
        System.out.println("**  **  ***   **   ******");
        System.out.println("**  **  ** ** **   *    *");
        System.out.println("******  **  ****   ******");
        System.out.println("\nDeveloped by Clean Coders, Inc");
        Scanner in = new Scanner(System.in);
        int opcion;
        boolean cerrar = false;
        while (true) {
        System.out.println();
        System.out.println("INGRESE UNA OPCION");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Cargar Partida");
        System.out.println("3. Salir");
        opcion = in.nextInt();
        in.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Iniciando una nueva partida...");
                    System.out.println("Partida iniciada. Haz click en ENTER para comenzar.");
                    in.nextLine();
                    JuegoUno.nuevaPartida();
                    break;
                case 2:
                    System.out.println("Opcion en mantenimiento, por favor, intentalo mas tarde...");
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    System.out.println("Cierre exitoso");
                    cerrar = true;
                    break;
            }
            if(cerrar) {
                break;
            }
        }
    }
}