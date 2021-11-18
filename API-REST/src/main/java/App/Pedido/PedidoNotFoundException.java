package App.Pedido;

class PedidoNotFoundException extends RuntimeException {

    PedidoNotFoundException(String codigo) {
        super("Could not find sala " + codigo);
    }
}
