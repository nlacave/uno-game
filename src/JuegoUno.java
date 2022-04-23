import java.util.Scanner;

public class JuegoUno {

    public static void nuevaPartida() {
        MesaJuego mesaJuego = new MesaJuego();
        Scanner in = new Scanner(System.in);
        boolean ganador = false;
        boolean pausa;
        int carta;
        mesaJuego.setTurnoJugador(1);
        while (!mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().isEmpty()) {
            mesaJuego.setCartaJugada(false);
            System.out.println("Turno jugador " + mesaJuego.turnoJugador + ": ");
            mesaJuego.mostrarCartaActiva();
            System.out.println();
            System.out.println("Cartas del jugador " + mesaJuego.turnoJugador + ": ");
            for (int i = 1; i <= mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().size(); i++) {
                System.out.print(i + ". [" + mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(i - 1) + "] | ");
            }
            boolean cartasParaTirar = false;
            boolean cartasAgarradas = false;
            while (!mesaJuego.isCartaJugada()) {
                System.out.println("\nElija una opción: ");
                System.out.println("1. Tirar una carta | 2. Agarrar carta del mazo | 3. Pasar | 4. Pausar");
                int opcionTurno = in.nextInt();
                in.nextLine();
                switch (opcionTurno) {
                    case 1:
                        try {
                            System.out.println("\nElija una carta: ");
                            carta = in.nextInt();
                            in.nextLine();
                            mesaJuego.efectoCarta(mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(carta - 1), mesaJuego.turnoJugador);
                            if (mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().size() == 1) {
                                System.out.println(mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getNombre() + ": UNO!");
                            }
                            if (mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().isEmpty()) {
                                ganador = true;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Esa carta no existe. Por favor, vuelve a intentarlo.");
                            break;
                        }
                    case 2:
                        while (!cartasAgarradas) {
                            for (int k = 0; k < mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().size(); k++) {
                                if (mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(k).getColor().equals(mesaJuego.getCartaActiva().getColor()) ||
                                        mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(k).getNumero() == mesaJuego.getCartaActiva().getNumero() ||
                                        mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(k).getNumero() >= 13) {
                                    cartasParaTirar = true;
                                    break;
                                }
                            }
                            if (cartasParaTirar) {
                                System.out.println("No puedes agarrar cartas del mazo. Intenta usar una carta de tu mano.");
                                break;
                            }
                            mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().add(mesaJuego.mazo.darCarta());
                            System.out.println("Agarraste una carta del mazo.");
                            System.out.println("Cartas del jugador " + mesaJuego.turnoJugador + ": ");
                            for (int i = 1; i <= mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().size(); i++) {
                                System.out.print(i + ". [" + mesaJuego.jugadores.get(mesaJuego.turnoJugador - 1).getCartasMano().get(i - 1) + "] | ");
                            }
                            cartasAgarradas = true;
                        }
                        if (cartasAgarradas) {
                            break;
                        }
                        break;
                    case 3:
                        if (!cartasParaTirar && cartasAgarradas) {
                            System.out.println("Haz pasado tu turno.");
                            mesaJuego.setCartaJugada(true);
                            break;
                        } else {
                            System.out.println("No puedes pasar el turno sin agarrar una carta.");
                        }

                    case 4:
                        int opcionMenu;
                        pausa = true;
                        while (pausa) {
                            System.out.println("1. Guardar Partida | 2. Salir | 3. Continuar Partida");
                            opcionMenu = in.nextInt();
                            in.nextLine();
                            switch (opcionMenu) {
                                case 1:
                                    System.out.println("Partida guardada exitosamente.");
                                    mesaJuego.guardado();
                                    break;
                                case 2:
                                    System.out.println("Saliendo de la partida...");
                                    System.out.println("Cierre exitoso.");
                                    System.exit(0);
                                    break;
                                case 3:
                                    System.out.println("Volviendo a la partida...");
                                    pausa = false;
                                    break;
                            }
                        }
                }
                if (!ganador && mesaJuego.isCartaJugada()) {
                    mesaJuego.cambiarTurno();
                }
                if (ganador) {
                    System.out.println("FELICITACIONES JUGADOR " + mesaJuego.turnoJugador + "! HAZ GANADO LA PARTIDA.");
                    System.exit(0);
                    break;
                }
            }
        }
    }
}