import java.util.ArrayList;
import java.util.List;

public class Jugador {
    public String getNombre() {
        return nombre;
    }

    private final String nombre;
    private List<CartaUno> cartasMano;

    public List<CartaUno> getCartasMano() {
        return cartasMano;
    }

    public Jugador(String nombre){
        this.nombre = nombre;
        cartasMano = new ArrayList<>();
    }

    //** AGREGAMOS CARTA A LA MANO DEL JUGADOR **
    public void setCartasMano(CartaUno carta) {
        this.cartasMano.add(carta);
    }

    //** MOSTRAMOS LA MANO DEL JUGADOR **
    public void mostrarMano(){
        System.out.println("\n*** MANO " + this.nombre + " ***");
        System.out.println(cartasMano);

    }

    /*** CANTIDAD DE CARTAS ***/
    /*public int cantCartas(){
        this.cartasMano.size();
    }*/

    //** JUEGA CARTA **
    public CartaUno jugarCarta(CartaUno carta){
        return carta;
    }
}