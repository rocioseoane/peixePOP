package App.Sala;

class SalaNotFoundException extends RuntimeException {

    SalaNotFoundException(String codigo) {
        super("Could not find sala " + codigo);
    }
}
