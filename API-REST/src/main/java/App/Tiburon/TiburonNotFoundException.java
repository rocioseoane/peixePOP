package App.Tiburon;

class TiburonNotFoundException extends RuntimeException {

    TiburonNotFoundException(String codigo) {
        super("Could not find tiburon " + codigo);
    }
}
