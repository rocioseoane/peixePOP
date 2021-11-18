package App.Articulo;

class ArticuloNotFoundException extends RuntimeException {

    ArticuloNotFoundException(String codigo) {
        super("Could not find articulo " + codigo);
    }
}
