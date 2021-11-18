package App.LineaPedido;

class LineaPedidoNotFoundException extends RuntimeException {

    LineaPedidoNotFoundException(String codigo) {
        super("Could not find linea pedido " + codigo);
    }
}
