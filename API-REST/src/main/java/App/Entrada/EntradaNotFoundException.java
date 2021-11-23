package App.Entrada;

public class EntradaNotFoundException extends RuntimeException {

    EntradaNotFoundException(String codigo) {
        super("Could not find entrada " + codigo);
    }
}
