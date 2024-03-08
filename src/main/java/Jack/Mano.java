package Jack;

import java.util.ArrayList;

class Mano {
    private ArrayList<Carta> cartas;
    private int puntuacion;

    public Mano() {
        this.cartas = new ArrayList<>();
        this.puntuacion = 0;
    }

    public void pedirCarta(Carta carta) {
        this.cartas.add(carta);
        this.puntuacion += carta.getValor();
    }

    public int valorMano() {
        return this.puntuacion;
    }

    public ArrayList<Carta> getCartas() {
        return this.cartas;
    }

    public boolean tieneCarta(Carta carta) {
        return this.cartas.contains(carta);
    }
}
