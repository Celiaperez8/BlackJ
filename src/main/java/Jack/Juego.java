package Jack;

import java.util.Scanner;

class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mazo mazo = new Mazo();
        mazo.barajar();

        Mano jugador = new Mano();

        while (true) {
            System.out.println("Tu mano:");
            for (Carta carta : jugador.getCartas()) {
                System.out.println(carta);
            }
            System.out.println("Puntuación: " + jugador.valorMano());

            if (jugador.valorMano() >= 21) {
                System.out.println("¡Fin del juego!");
                if (jugador.valorMano() == 21) {
                    System.out.println("¡Has alcanzado 21! ¡Felicidades, has ganado!");
                } else {
                    System.out.println("Te has pasado de 21. Has perdido.");
                }
                break;
            }

            System.out.println("¿Quieres otra carta? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                Carta carta = mazo.solicitarCarta();
                jugador.pedirCarta(carta);

                // Verificar si el jugador tiene la carta 7 de corazones
                Carta carta7Corazones = new Carta(7, Carta.Palo.CORAZONES);
                if (jugador.tieneCarta(carta7Corazones)) {
                    System.out.println("¡Tienes la carta 7 de corazones en tu mano!");
                }
            } else if (respuesta.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Respuesta no válida. Por favor, responde 's' para sí y 'n' para no.");
            }
        }

        scanner.close();
        System.out.println("Fin del juego. Tu puntuación final es: " + jugador.valorMano());

        // Guardar los resultados en XML
        Resultados resultadosXML = new Resultados("resultados.xml");
        resultadosXML.guardarResultado(jugador.valorMano());
    }
}
