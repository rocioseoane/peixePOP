package App.Factura;

class FacturaNotFoundException extends RuntimeException {

    FacturaNotFoundException(String codigo) {
        super("Could not find sala " + codigo);
    }
}
