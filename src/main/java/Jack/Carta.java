package Jack;
class Carta {
    enum Palo {
        TREBOL, DIAMANTES, CORAZONES, PICAS
    }

    public int numero;
    public Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }


    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        if (numero == 1) {
            return 11;
        } else if (numero > 9) {
            return 10;
        } else {
            return numero;
        }
    }

    public String mostrarNumero() {
        switch (numero) {
            case 1:
                return "AS";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(numero);
        }
    }

    @Override
    public String toString() {
        return "[" + mostrarNumero() + " - " + palo + "]";
    }
}