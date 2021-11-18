package Cliente;

class ClienteNotFoundException extends RuntimeException {

    ClienteNotFoundException(String codigo) {
        super("Could not find client " + codigo);
    }
}