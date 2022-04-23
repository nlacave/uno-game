public class CartaUno {
    private String color;
    private int numero;

    public static final String[] COLORES = {"ROJO", "AMARILLO", "AZUL", "VERDE", "NEGRO"};
    public static final int CARTASxCOLOR = 28;

    public CartaUno(String color, int numero) {
        this.color = color;
        this.numero = numero;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        String tipoCarta;
        if (this.numero <= 9) return this.numero + " " + this.color;
        else if (this.numero == 10) tipoCarta = "CAMBIO SENTIDO";
        else if (this.numero == 11) tipoCarta = "+2";
        else if (this.numero == 12) tipoCarta = "BLOQUEO";
        else if (this.numero == 13) tipoCarta = "+4";
        else tipoCarta = "CAMBIA COLOR";

        if (this.getNumero() == 13 || this.getNumero() == 14) {
            return tipoCarta;
        } else {
            return tipoCarta + " " + this.getColor();
        }
    }

    public boolean isCarta0al9(CartaUno cartaActiva) {
        if (this.getNumero() <= 9) {
            return cartaActiva.getNumero() == this.getNumero() ||
                    cartaActiva.getColor().equals(this.getColor());
        } else {
            return false;
        }
    }

    public boolean isMasDos(CartaUno cartaActiva) {
        if (this.getNumero() == 11) {
            return cartaActiva.getNumero() == this.getNumero() ||
                    cartaActiva.getColor().equals(this.getColor());
        } else {
            return false;
        }
    }

    public boolean isMasCuatro() {
        return this.getNumero() == 13;
    }

    public boolean isCambioColor() {
        return this.getNumero() == 14;
    }

    public boolean isCambioSentido(CartaUno cartaActiva) {
        if (this.getNumero() == 10) {
            return cartaActiva.getNumero() == this.getNumero() ||
                    cartaActiva.getColor().equals(this.getColor());
        }
        return false;
    }

    public boolean isBloqueoTurno(CartaUno cartaActiva) {
        if (this.getNumero() == 12) {
            return cartaActiva.getNumero() == this.getNumero() ||
                    cartaActiva.getColor().equals(this.getColor());
        }
        return false;
    }
}