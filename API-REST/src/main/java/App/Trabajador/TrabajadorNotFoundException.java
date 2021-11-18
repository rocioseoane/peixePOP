package App.Trabajador;

class TrabajadorNotFoundException extends RuntimeException {

    TrabajadorNotFoundException(String codigo) {
        super("Could not find trabajador " + codigo);
    }
}
