package App.LineaFactura;

class LineaFacturaNotFoundException extends RuntimeException {

    LineaFacturaNotFoundException(String codigo) {
        super("Could not find linea factura " + codigo);
    }
}
