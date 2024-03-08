package Jack;
import java.util.ArrayList;
import java.util.Collections;
public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas.add(new Carta(numero, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta solicitarCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("No quedan cartas en el mazo");
        }
        return cartas.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta).append("\n");
        }
        return sb.toString();
    }
}
